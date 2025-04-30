package com.backend.cheapflights.tests;

import java.util.List;
import org.springframework.web.client.RestTemplate;

import com.backend.cheapflights.models.Airport;


public class EndpointTester {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.ryanair.com/api/views/locate/5/airports/en/active";
        String rawString = restTemplate.getForObject(url, String.class);
        Airport[] airports = restTemplate.getForObject(url, Airport[].class);
        System.out.println(airports);
    }
}
