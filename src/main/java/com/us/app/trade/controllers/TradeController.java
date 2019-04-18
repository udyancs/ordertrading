package com.us.app.trade.controllers;

import com.us.app.trade.dto.TradeRequest;
import com.us.app.trade.dto.TradeSummaryResponse;
import com.us.app.trade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Udyan Shardhar
 * Trade controller to rest end points for api.
 */
@RestController
@RequestMapping("/trade")
@Validated
public class TradeController {

    @Autowired
    private TradeService tradeService;

    /**
     *
     * @param tradeRequest trade request object
     * @return TradeResponse value object
     */
    @PostMapping
    public String orders(@RequestBody TradeRequest tradeRequest) {
        return tradeService.addOrders(tradeRequest);
    }

    @GetMapping("/summary")
    public TradeSummaryResponse orderSummary() {
        TradeSummaryResponse orderSummary = tradeService.getOrderSummary();
        return orderSummary;
    }

    @GetMapping("/summary/security/{security}")
    public TradeSummaryResponse orderSummaryBySecurity(@PathVariable String security){
        TradeSummaryResponse orderSummaryBySecurity = tradeService.getOrderSummaryBySecurity(security);
        return orderSummaryBySecurity;
    }

    @GetMapping("/summary/fund/{fund}")
    public TradeSummaryResponse orderSummaryByFund(@PathVariable String fund){
        TradeSummaryResponse orderSummaryByFund = tradeService.getOrderSummaryByFund(fund);
        return orderSummaryByFund;
    }
}
