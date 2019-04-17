package com.us.app.trade.dto;

public class Combine {
    private String side;
    private String fund;
    private String security;

    public Combine(String side, String fund, String security) {
        this.side = side;
        this.fund = fund;
        this.security = security;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj instanceof Combine) {
           Combine c = (Combine) obj;
           return this.fund.equals(c.fund)
                   && this.security.equals(c.security)
                   && this.side.equals(c.side);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        String temp = side + fund + security;
        return  (prime * result) + temp.hashCode();
    }


    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
