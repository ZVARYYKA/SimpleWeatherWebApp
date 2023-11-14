package com.ru.weatherwebapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private CurrentWeather current;

    public String getCity() {
        return location.getName();
    }

    public String getRegion() {
        return location.getRegion();
    }

    public double getTemperatureC() {
        return current.getTemp_c();
    }

    public String getCondition() {
        return current.getCondition().getText();
    }
}