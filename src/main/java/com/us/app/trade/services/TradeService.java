package com.us.app.trade.services;

import com.us.app.trade.dto.TradeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



/**
 * @author Udyan Shardhar
 */
@Service
public class TradeService {

    @Value( "${weather.api.app.id}" )
    private String apiId;

    @Value( "${weather.api.app.code}" )
    private String apiCode;


    @Value( "${weather.api.country.code}" )
    private String countryCode;


    @Autowired
    private DataModelService dataModelService;

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    public String addOrders(TradeRequest tradeRequest) {
        logger.info("Saving trade ");
        dataModelService.insertOrders(tradeRequest);
        return "Success";
    }

}
