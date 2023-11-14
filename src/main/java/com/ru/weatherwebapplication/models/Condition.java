package com.ru.weatherwebapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public  class Condition {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

}

