package com.us.app.trade.services;

import com.us.app.trade.dto.TradeRequest;
import com.us.app.trade.dto.TradeSummaryResponse;
import com.us.app.trade.repository.InMemoryDataModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author Udyan Shardhar
 */
@Service
public class TradeService {

    @Autowired
    private InMemoryDataModelService inMemoryDataModelService;

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    public String addOrders(TradeRequest tradeRequest) {
        logger.info("Saving trade ");
        inMemoryDataModelService.insertOrders(tradeRequest);
        return "Success";
    }

    public TradeSummaryResponse getOrderSummary() {
        logger.info("pulling overall order summary");
        return inMemoryDataModelService.getTradeSummaryResponse();
    }

    public TradeSummaryResponse getOrderSummaryByFund(String fund) {
        logger.info("pulling order summary for fund {}", fund);
        return inMemoryDataModelService.getTradeSummaryByFund(fund);
    }

    public TradeSummaryResponse getOrderSummaryBySecurity(String security) {
        logger.info("pulling order summary for security {}", security);
        return inMemoryDataModelService.getTradeSummaryBySecurity(security);
    }

}
