package com.us.app.trade.dto;

public class TradeAnalysis {
    private long numberOfOrders;
    private long totalQuantity;
    private double avgPrice;

    public TradeAnalysis(long numberOfOrders, long totalQuantity, double avgPrice) {
        this.numberOfOrders = numberOfOrders;
        this.totalQuantity = totalQuantity;
        this.avgPrice = avgPrice;
    }

    public long getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(long numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }
}
