package com.us.app.trade.services;

import com.us.app.trade.dto.Combine;
import com.us.app.trade.dto.Trade;
import com.us.app.trade.dto.TradeAnalysis;
import com.us.app.trade.dto.TradeRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataModelService {

    private static Logger log = LoggerFactory.getLogger(DataModelService.class);
    private static long numberOfOrders;
    private static long totalQuantity ;
    private static double avgPrice;
    private static double totalPrice;
    private static String combinableOrder;

    private static Map<String, Trade> IN_MEMORY_TRADES = new HashMap<>();
    private static Map<Combine, TradeAnalysis> SUMMARY_DATA = new HashMap<>();
    private static Map<Combine, TradeAnalysis> SUMMARY_DATA_BY = new HashMap<>();

    @Async("threadPoolTaskExecutor")
    public void insertOrders(TradeRequest tradeRequest) {
        try {
            System.out.println("Execute method with configured executor - "
                    + Thread.currentThread().getName());
            Thread.sleep(10000);
            tradeRequest.getTrades().forEach(p -> {
                IN_MEMORY_TRADES.put(p.getOrderId(), p);
                // analysis(p);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis());
        prepareSummaryData();
    }

    private void analysis(Trade trade){
        long numberOfOrders = 1;
        long totalQuantity = 0;
        double avgPrice;
        Combine combine = new Combine(trade.getSide(), trade.getFund(), trade.getSecurity());
        TradeAnalysis tradeAnalysis = SUMMARY_DATA_BY.get(combine);
        if(tradeAnalysis != null) {
            numberOfOrders = numberOfOrders + tradeAnalysis.getNumberOfOrders();
            totalQuantity = totalQuantity + tradeAnalysis.getTotalQuantity();
            avgPrice = ((tradeAnalysis.getAvgPrice() * tradeAnalysis.getNumberOfOrders()) + trade.getPrice()) / numberOfOrders;
        }else {
            totalQuantity = trade.getQuantity();
            avgPrice = trade.getPrice();
        }
        SUMMARY_DATA_BY.put(combine, new TradeAnalysis(numberOfOrders, totalQuantity, avgPrice));
    }

    public void prepareSummaryData() {
        long startTime = System.currentTimeMillis();
        log.debug("Starting analysis at {}", startTime);
        System.out.println("Starting analysis at" + startTime);
        IN_MEMORY_TRADES.values().forEach(p -> {
            totalQuantity = totalQuantity + p.getQuantity();
            numberOfOrders = numberOfOrders +1;
            totalPrice = totalPrice + p.getPrice();
            analysis(p);
        });
        avgPrice = totalPrice/numberOfOrders;
        SUMMARY_DATA_BY.forEach((key, value) -> {
            if(value.getNumberOfOrders() > 1){
                String s = value.getNumberOfOrders() + "(" + key.getSide() + "+" + key.getSecurity() + "+" + key.getFund() + ")";
                combinableOrder = StringUtils.isEmpty(combinableOrder) ?  s : combinableOrder +", " + s;
            }
        });

        long finishTime = System.currentTimeMillis();
        log.debug("Finishing analysis at {}", finishTime);
        log.debug("Analysis time duration {}", finishTime-startTime);
        System.out.println("Finishing analysis at" + finishTime);
        System.out.println("Analysis time duration" + (finishTime-startTime));
    }
}
