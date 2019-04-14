package com.us.app.trade.utils;

import com.google.gson.Gson;
import com.us.app.trade.clients.dto.WeatherResponseDTO;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.us.app.trade.constants.ApplicationConstants.WEATHER_API_PRODUCT_NAME;
import static com.us.app.trade.constants.ApplicationConstants.WEATHER_API_URL;

public class ClientUtility {
    /**
     * buildServiceURL return Weather report service end point URL string.
     * @param zipCode zip code
     * @return String serviceUrl end point
     */
    public static URI buildServiceUri(String zipCode, String appId, String appCode){
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(WEATHER_API_URL)
                .queryParam("product", WEATHER_API_PRODUCT_NAME)
                .queryParam("zipcode", zipCode)
                .queryParam("metric", false)
                .queryParam("app_id", appId)
                .queryParam("app_code", appCode)
                .queryParam("hourlydate", getTomorrowDate())
                .encode()
                .build();

        return uriComponents.expand().toUri();
    }

    public static WeatherResponseDTO getResponseDTOObject(String response) {
        Gson objectMapper = new Gson();
        return objectMapper.fromJson(response, WeatherResponseDTO.class);
    }

    private static String getTomorrowDate(){
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 1);
        currentDate = c.getTime();

        return format2.format(currentDate);

    }
}
