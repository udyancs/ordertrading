package com.us.app.trade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Udyan Shardhar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeSummaryResponseBuilder extends Response{
    private long numberOfOrders;
    private long totalQuantity;
    private double avgPrice;
    private String totalCombinableOrders;
    private ApiError error;

    public TradeSummaryResponseBuilder withNumberOfOrders(long numberOfOrders){
        this.numberOfOrders = numberOfOrders;
        return this;
    }

    public TradeSummaryResponseBuilder withTotalCombinableOrders(String totalCombinableOrders){
        this.totalCombinableOrders = totalCombinableOrders;
        return this;
    }

    public TradeSummaryResponseBuilder withTotalQuantity(long totalQuantity){
        this.totalQuantity = totalQuantity;
        return this;
    }

    public TradeSummaryResponseBuilder withAvgPrice(double avgPrice){
        this.avgPrice = avgPrice;
        return this;
    }


    public TradeSummaryResponseBuilder withError(ApiError error){
        this.error = error;
        return this;
    }

    public TradeSummaryResponse build(){
        return new TradeSummaryResponse(this);
    }

    public long getNumberOfOrders() {
        return numberOfOrders;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public String getTotalCombinableOrders() {
        return totalCombinableOrders;
    }

    public ApiError getError() {
        return error;
    }
}
