package com.us.app.trade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeSummaryResponse extends Response {
    private long numberOfOrders;
    private long totalQuantity;
    private double avgPrice;
    private String combinableOrders;
    public ApiError error;

    public TradeSummaryResponse(TradeSummaryResponseBuilder builder) {
        this.numberOfOrders = builder.getNumberOfOrders();
        this.totalQuantity = builder.getTotalQuantity();
        this.avgPrice = builder.getAvgPrice();
        this.combinableOrders = builder.getTotalCombinableOrders();
        this.error = builder.getError();
    }

    public TradeSummaryResponse() {
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

    public String getCombinableOrders() {
        return combinableOrders;
    }

    public ApiError getError() {
        return error;
    }
}
