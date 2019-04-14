package com.us.app.trade.dto;

import java.util.List;

public class TradeSummaryResponse extends Response {
    private int numberOfOrders;
    private int totalQuantity;
    private double avgPrice;
    private List<CombinableOrder> combinableOrders;

    public TradeSummaryResponse(TradeSummaryResponseBuilder builder) {
        this.numberOfOrders = builder.getNumberOfOrders();
        this.totalQuantity = builder.getTotalQuantity();
        this.avgPrice = builder.getAvgPrice();
        this.combinableOrders = builder.getCombinableOrders();
    }

    public TradeSummaryResponse() {
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
