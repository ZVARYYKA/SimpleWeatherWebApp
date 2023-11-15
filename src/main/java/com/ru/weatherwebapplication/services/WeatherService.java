package com.ru.weatherwebapplication.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.weatherwebapplication.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${WeatherApiKey}")
    private String weatherApiKey;

    public Weather findWeatherForCity(String city) throws JsonProcessingException {
        RestTemplate template = new RestTemplate();

        String apiKey;
        String json = template.getForObject(
                "http://api.weatherapi.com/v1/current.json?key=" + weatherApiKey + "&q=" + city + "&aqi=no", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = null;
        return weather = objectMapper.readValue(json, Weather.class);
    }
}
