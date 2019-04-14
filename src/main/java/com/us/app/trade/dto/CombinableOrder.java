package com.us.app.trade.dto;

public class CombinableOrder {
    private String Security;
    private String fund;
    private int totalNumber;

    public String getSecurity() {
        return Security;
    }

    public void setSecurity(String security) {
        Security = security;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }
}
