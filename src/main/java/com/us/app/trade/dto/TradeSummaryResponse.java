package com.us.app.trade.dto;

public class TradeSummaryResponse extends Response {
    private long numberOfOrders;
    private long totalQuantity;
    private double avgPrice;
    private long combinableOrders;

    public TradeSummaryResponse(TradeSummaryResponseBuilder builder) {
        this.numberOfOrders = builder.getNumberOfOrders();
        this.totalQuantity = builder.getTotalQuantity();
        this.avgPrice = builder.getAvgPrice();
        this.combinableOrders = builder.getTotalCombinableOrders();
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

    public long getCombinableOrders() {
        return combinableOrders;
    }
}
