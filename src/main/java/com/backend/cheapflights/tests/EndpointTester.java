package com.backend.cheapflights.tests;

import java.util.List;
import java.time.LocalDate;

import org.springframework.web.client.RestTemplate;
import com.backend.cheapflights.models.Airport;


public class EndpointTester {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.ryanair.com/api/farfnd/v4/oneWayFares/LIS/CRL/availabilities";
        LocalDate[] response = restTemplate.getForObject(url, LocalDate[].class);
        Airport[] airports = restTemplate.getForObject(url, Airport[].class);
        //System.out.println(airports);
    }
}
