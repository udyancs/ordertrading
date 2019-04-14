/*
package com.us.app.trade.utils;

import com.us.app.trade.clients.dto.Forecast;
import com.us.app.trade.clients.dto.WeatherResponseDTO;
import com.us.app.trade.dto.Trade;
import com.us.app.trade.dto.TradeSummaryResponse;
import com.us.app.trade.dto.TradeSummaryResponseBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

*/
/**
 * @author Udyan Shardhar
 * Utility class for weather application.
 *//*

public class ServiceUtility {

    public static TradeSummaryResponseBuilder buildWeatherResponseVO(WeatherResponseDTO weatherResponseDTO){
        TradeSummaryResponseBuilder tradeResponseBuilder =new TradeSummaryResponseBuilder();
        String city = weatherResponseDTO.getHourlyForecasts().getForecastLocation().getCity();
        String state = weatherResponseDTO.getHourlyForecasts().getForecastLocation().getState();
        String country = weatherResponseDTO.getHourlyForecasts().getForecastLocation().getCountry();
        List<Forecast> forecast = weatherResponseDTO.getHourlyForecasts().getForecastLocation().getForecast();

        // Finds the coolest hour of tomorrow for the  given zip code
        ArrayList<Double> tempList = new ArrayList<>();
        forecast.forEach(p -> {
            tempList.add(Double.parseDouble(p.getTemperature()));
        });
        Double coolestTemperature = Collections.min(tempList);

        // Hourly Report
        List<Trade> tradeList = forecast.stream().map(ServiceUtility::prepareTemp).collect(Collectors.toList());
        String date = tradeList.get(0).getDate();
        return tradeResponseBuilder
                .withCity(city)
                .withCountry(country)
                .withState(state)
                .withHourlyForecast(tradeList)
                .withCoolestTemperature(coolestTemperature)
                .withDate(date);
    }

    private static Trade prepareTemp(Forecast forecast){
        TradeBuilder forecastsVOBuilder = new TradeBuilder();
        double temperature = Double.parseDouble(forecast.getTemperature());
        String localTime = forecast.getLocalTime();
        String humidity = forecast.getHumidity();
        String description = forecast.getDescription();
        String day = forecast.getWeekday();

        String time = localTime.substring(0, 2);
        String date = localTime.substring(2);
        date = date.substring(0, 2) + "-" + date.substring(2, 4) + "-" + date.substring(4, 8);

        return forecastsVOBuilder.withDay(day)
                .withDate(date)
                .withDescription(description)
                .withHumidity(humidity)
                .withTemperature(temperature)
                .withTime(time)
                .withDay(day)
                .build();
    }
}
*/
