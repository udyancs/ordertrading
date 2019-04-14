package com.us.app.trade.clients.dto;

public class Forecast {

    private String daylight;
    private String description;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String visibility;
    private String weekday;
    private String localTime;
    private String localTimeFormat;

    public String getDaylight() {
        return daylight;
    }

    public void setDaylight(String daylight) {
        this.daylight = daylight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getLocalTimeFormat() {
        return localTimeFormat;
    }

    public void setLocalTimeFormat(String localTimeFormat) {
        this.localTimeFormat = localTimeFormat;
    }
}
