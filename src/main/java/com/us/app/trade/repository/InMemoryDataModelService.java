package com.us.app.trade.repository;

import com.us.app.trade.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class InMemoryDataModelService {

    private static Logger log = LoggerFactory.getLogger(InMemoryDataModelService.class);
    private static Map<String, Trade> IN_MEMORY_TRADES = new HashMap<>();

    private static TradeSummaryResponse tradeSummaryResponse = new TradeSummaryResponse();
    private static Map<String, TradeSummaryResponse> GROUP_BY_SECURITY = new HashMap<>();
    private static Map<String, TradeSummaryResponse> GROUP_BY_FUND = new HashMap<>();

    public TradeSummaryResponse getTradeSummaryResponse() {
        return tradeSummaryResponse;
    }


    public TradeSummaryResponse getTradeSummaryBySecurity(String security) {
        return GROUP_BY_SECURITY.get(security);
    }

    public TradeSummaryResponse getTradeSummaryByFund(String fund) {
        return GROUP_BY_FUND.get(fund);
    }


    @Async("threadPoolTaskExecutor")
    public void insertOrders(TradeRequest tradeRequest) {
        try {
            System.out.println("Execute method with configured executor - "
                    + Thread.currentThread().getName());
            Thread.sleep(10000);
            tradeRequest.getTrades().forEach(p -> IN_MEMORY_TRADES.put(p.getOrderId(), p));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        prepareSummaryData();
        groupBySecuirty();
        groupByFund();
    }

    public Map<String, TradeSummaryResponse> prepareGroupData(ConcurrentMap<String, List<Trade>> groupBySecuirty){
        long startTime = System.currentTimeMillis();
        Map<String, TradeSummaryResponse> groupByType = new HashMap<>();
        groupBySecuirty.values().forEach(p -> {
            final long[] totalQuantity = new long[1];
            final double[] totalPrice = new double[1];
            final String[] orderId = new String[1];
            p.forEach(p1 -> {
                totalQuantity[0] = totalQuantity[0] + p1.getQuantity();
                totalPrice[0] = totalPrice[0] + p1.getPrice();
                orderId[0] = p1.getOrderId();
            });
            int numberOfOrders = p.size();
            double avgPrice = totalPrice[0] / numberOfOrders;

            HashMap<Combine, Long> groupData = new HashMap<>();
            p.forEach(trade -> {
                Combine combine = new Combine(trade.getSide(), trade.getFund(), trade.getSecurity());
                if(groupData.containsKey(combine)){
                    long value = groupData.get(combine) + 1;
                    groupData.put(combine, value);
                }else {
                    groupData.put(combine, 1L);
                }

            });

            long totalCombinableOrders = groupData.values().stream().filter(p3 -> p3 > 1).count();
            TradeSummaryResponse tradeResponse = new TradeSummaryResponseBuilder()
                    .withAvgPrice(avgPrice)
                    .withNumberOfOrders(numberOfOrders)
                    .withTotalQuantity(totalQuantity[0])
                    .withTotalCombinableOrders(totalCombinableOrders)
                    .build();
            groupByType.put(orderId[0], tradeResponse);
        });
        long finishTime = System.currentTimeMillis();
        System.out.println("Analysis time duration to prepare group data " + (finishTime-startTime));
        return groupByType;
    }

    public void groupBySecuirty() {
        ConcurrentMap<String, List<Trade>> groupBySecuirty = IN_MEMORY_TRADES.values().stream().collect(Collectors.groupingByConcurrent(Trade::getSecurity));
        GROUP_BY_SECURITY = prepareGroupData(groupBySecuirty);
    }

    public void groupByFund(){
        ConcurrentMap<String, List<Trade>> groupByFund = IN_MEMORY_TRADES.values().stream().collect(Collectors.groupingByConcurrent(Trade::getFund));
        GROUP_BY_FUND = prepareGroupData(groupByFund);
    }

    public void prepareSummaryData() {
        final long[] numberOfOrders = new long[1];
        final long[] totalQuantity = new long[1];
        final double[] totalPrice = new double[1];
        long startTime = System.currentTimeMillis();
        IN_MEMORY_TRADES.values().forEach(p -> {
            totalQuantity[0] = totalQuantity[0] + p.getQuantity();
            numberOfOrders[0] = numberOfOrders[0] +1;
            totalPrice[0] = totalPrice[0] + p.getPrice();
        });
        double avgPrice = totalPrice[0] / numberOfOrders[0];
        Map<Combine, Long> combineLongMap = prepareGroupedData();
        long totalCombinableOrders = combineLongMap.values().stream().filter(p -> p > 1).count();
        tradeSummaryResponse = new TradeSummaryResponseBuilder()
                .withAvgPrice(avgPrice)
                .withNumberOfOrders(numberOfOrders[0])
                .withTotalQuantity(totalQuantity[0])
                .withTotalCombinableOrders(totalCombinableOrders)
                .build();
        long finishTime = System.currentTimeMillis();
        log.debug("Analysis time duration {}", finishTime-startTime);
        System.out.println("Analysis time duration to prepare summary data " + (finishTime-startTime));
    }

    public Map<Combine, Long> prepareGroupedData(){
        Map<Combine, Long> combineLongMap = new HashMap<>();
        IN_MEMORY_TRADES.values().forEach(trade -> {
            Combine combine = new Combine(trade.getSide(), trade.getFund(), trade.getSecurity());
            if(combineLongMap.containsKey(combine)){
                long value = combineLongMap.get(combine) + 1;
                combineLongMap.put(combine, value);
            }else {
                combineLongMap.put(combine, 1L);
            }

        });
        return combineLongMap;
    }
}
