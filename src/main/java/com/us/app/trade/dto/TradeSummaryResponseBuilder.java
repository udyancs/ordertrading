package com.us.app.trade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Udyan Shardhar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeSummaryResponseBuilder extends Response{
    private int numberOfOrders;
    private int totalQuantity;
    private double avgPrice;
    private List<CombinableOrder> combinableOrders;

    public TradeSummaryResponseBuilder withNumberOfOrders(int numberOfOrders){
        this.numberOfOrders = numberOfOrders;
        return this;
    }

    public TradeSummaryResponseBuilder withTotalQuantity(int totalQuantity){
        this.totalQuantity = totalQuantity;
        return this;
    }

    public TradeSummaryResponseBuilder withAvgPrice(double avgPrice){
        this.avgPrice = avgPrice;
        return this;
    }

    public TradeSummaryResponseBuilder withCombinableOrders(List<CombinableOrder> combinableOrders){
        this.combinableOrders = combinableOrders;
        return this;
    }


    public TradeSummaryResponseBuilder withError(ApiError error){
        this.error = error;
        return this;
    }

    public TradeSummaryResponse build(){
        return new TradeSummaryResponse(this);
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public List<CombinableOrder> getCombinableOrders() {
        return combinableOrders;
    }
}
