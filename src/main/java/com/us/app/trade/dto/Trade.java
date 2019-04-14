package com.us.app.trade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Trade {
    private String orderId;
    private String side;
    private String security;
    private Double price;
    private String fund;
    private int quantity;

    public String getOrderId() {
        return orderId;
    }

    public String getSide() {
        return side;
    }

    public String getSecurity() {
        return security;
    }

    public Double getPrice() {
        return price;
    }

    public String getFund() {
        return fund;
    }

    public int getQuantity() {
        return quantity;
    }
}
