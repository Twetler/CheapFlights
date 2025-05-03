package com.backend.cheapflights;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

// Logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.backend.cheapflights.constants.ApiEndpoints;
import com.backend.cheapflights.models.Airport;

// Views templates
@Controller
public class PageController{

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    // Home Page Template
    @GetMapping("/home")
    public String home(
        @RequestParam(required = false) String origin,
        @RequestParam(required = false) String destination,
        Model model) {

            RestTemplate restTemplate = new RestTemplate();
            Airport[] airports = restTemplate.getForObject(ApiEndpoints.Airports.listAllUrl, Airport[].class);
            
            
            
            // BTN Search Flights
            if (origin != null && destination != null) {
                logger.info("Searching flights from " + origin + " to " + destination);
                String datesUrl = String.format(ApiEndpoints.Flights.getDates, origin, destination);
                LocalDate[] flightDates = restTemplate.getForObject(datesUrl, LocalDate[].class);
                
                Integer datesSize = (flightDates != null) ? flightDates.length: 0;
                logger.info("Dates returned: " + datesSize);
                model.addAttribute("flightDates", flightDates);    
                logger.error("No flight for the origin/destination chosen.");
            }

            // Return Thymeleaf models
            model.addAttribute("airports", airports);
            model.addAttribute("origin", origin);
            model.addAttribute("destination", destination);

            return "home";



    }
}