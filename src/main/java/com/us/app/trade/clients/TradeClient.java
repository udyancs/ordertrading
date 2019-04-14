package com.us.app.trade.clients;

import com.us.app.trade.clients.dto.WeatherResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.us.app.trade.utils.ClientUtility.buildServiceUri;
import static com.us.app.trade.utils.ClientUtility.getResponseDTOObject;


@Component
public class TradeClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TradeClient.class);

    public WeatherResponseDTO getTomorrowWeather(String zipCode, String apiId, String apiCode, String countryCode) throws RestClientException{
        logger.info("Requesting current weather for zip code {} for country {}", zipCode, countryCode);
        URI uri = buildServiceUri(zipCode, apiId, apiCode);
        String response = invoke(uri, String.class);
        return getResponseDTOObject(response);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = restTemplate
                .exchange(request, responseType);
        return exchange.getBody();
    }

}
