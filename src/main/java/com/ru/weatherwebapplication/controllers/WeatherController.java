package com.ru.weatherwebapplication.controllers;

import com.ru.weatherwebapplication.models.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/weather/{city}")
    public Weather getWeather(@PathVariable String city) {
        //здесь напишите код для запроса данных о погоде из OpenWeatherMap и заполнения объекта Weather
        return new Weather();
    }
}