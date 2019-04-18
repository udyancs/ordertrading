package com.us.app.trade.services;

import com.us.app.trade.dto.ApiError;
import com.us.app.trade.dto.TradeRequest;
import com.us.app.trade.dto.TradeSummaryResponse;
import com.us.app.trade.dto.TradeSummaryResponseBuilder;
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
        TradeSummaryResponse tradeSummaryResponse = inMemoryDataModelService.getTradeSummaryResponse();
        return buildResponse(tradeSummaryResponse);
    }

    public TradeSummaryResponse getOrderSummaryByFund(String fund) {
        logger.info("pulling order summary for fund {}", fund);
        TradeSummaryResponse tradeSummaryByFund = inMemoryDataModelService.getTradeSummaryByFund(fund);
        return buildResponse(tradeSummaryByFund);
    }

    public TradeSummaryResponse getOrderSummaryBySecurity(String security){
        logger.info("pulling order summary for security {}", security);

        TradeSummaryResponse tradeSummaryBySecurity = inMemoryDataModelService.getTradeSummaryBySecurity(security);
        return buildResponse(tradeSummaryBySecurity);
    }

    private TradeSummaryResponse buildResponse(TradeSummaryResponse response){
        if(response == null)
            return new TradeSummaryResponseBuilder()
                    .withError(new ApiError("Resource not found", "", "RESOURCE_NOT_FOUND"))
                    .build();
        return response;
    }
}
