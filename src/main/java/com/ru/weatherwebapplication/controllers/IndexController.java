package com.ru.weatherwebapplication.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ru.weatherwebapplication.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class IndexController {

    private final WeatherService weatherService;

    @Autowired
    public IndexController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/weather")
    public String weather(@RequestParam(name = "city") String city, Model model) {

        try {
            model.addAttribute("weather", weatherService.findWeatherForCity(city));
        } catch (JsonProcessingException e) {
            return "error";
        }


        return "weather";

    }

}
