package com.backend.cheapflights.tests;

import java.util.List;
import java.time.LocalDate;

import org.springframework.web.client.RestTemplate;
import com.backend.cheapflights.models.FlightSearchResult;


public class EndpointTester {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.ryanair.com/api/booking/v4/en-gb/availability?DateOut=2025-05-16&Destination=CRL&Origin=LIS&ToUs=AGREED";
        String raw_response = restTemplate.getForObject(url, String.class);
        FlightSearchResult searchResults = restTemplate.getForObject(url, FlightSearchResult.class);
        System.out.println(searchResults);
    }
}
