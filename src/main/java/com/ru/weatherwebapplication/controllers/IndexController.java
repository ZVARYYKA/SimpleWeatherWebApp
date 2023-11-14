package com.ru.weatherwebapplication.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.weatherwebapplication.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class IndexController {
    @Value("${WeatherApiKey}")
    private String weatherApiKey;
    @GetMapping()
    public String index() {
        return "index";
    }
    @GetMapping("/weather")
    public String weather(@RequestParam(name = "city") String city, Model model) throws JsonProcessingException {
        RestTemplate template = new RestTemplate();

        String apiKey;
        String json = template.getForObject(
                "http://api.weatherapi.com/v1/current.json?key="+weatherApiKey+"&q="+city+"&aqi=no", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = objectMapper.readValue(json, Weather.class);



        model.addAttribute("weather",weather);

        return "weather";

    }

}
