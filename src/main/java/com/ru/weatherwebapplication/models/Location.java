package com.ru.weatherwebapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String name;
    private String region;

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }
// Define getters and setters for the properties
}