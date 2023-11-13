package com.ru.weatherwebapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping()
    public String index() {
        return "index";
    }
    @GetMapping("/{city}")
    public String weather()
    {
        return "weather";

    }

}
