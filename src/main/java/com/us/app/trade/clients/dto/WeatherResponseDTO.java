package com.us.app.trade.clients.dto;

public class WeatherResponseDTO {

    private HourlyForcasts hourlyForecasts;
    private  String metric;

    public HourlyForcasts getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(HourlyForcasts hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
