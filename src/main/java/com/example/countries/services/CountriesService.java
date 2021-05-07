package com.example.countries.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountriesService {

    private final RestTemplate restTemplate;

    public CountriesService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPlainJSON(String country) throws ParseException {
        String url = "https://restcountries.eu/rest/v2/name/" + country;
        String jsonString = this.restTemplate.getForObject(url, String.class);

        return jsonString;
    }

}
