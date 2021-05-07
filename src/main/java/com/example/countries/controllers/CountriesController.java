package com.example.countries.controllers;

import com.example.countries.services.CountriesService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")

public class CountriesController {

    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/{country}")
    public String getFlag(@PathVariable("country") String country) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(countriesService.getPlainJSON(country));
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String flag = (String) jsonObject.get("flag");

        return "The flag url is: " + flag;
    }

}
