package com.ru.weatherwebapplication.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.weatherwebapplication.models.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping()
    public String index() {
        return "index";
    }
    @GetMapping("/{city}")
    public String weather(@PathVariable String city, Model model) throws JsonProcessingException {
        RestTemplate template = new RestTemplate();
        String json = template.getForObject(
                "http://api.weatherapi.com/v1/current.json?key=a815f81683e84ce3bf1172731231311&q=London&aqi=no", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = objectMapper.readValue(json, Weather.class);



        model.addAttribute("weather",weather);

        return "weather";

    }

}
