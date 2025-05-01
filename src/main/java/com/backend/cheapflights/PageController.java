package com.backend.cheapflights;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.backend.cheapflights.constants.ApiEndpoints;
import com.backend.cheapflights.models.Airport;

// Views templates
@Controller
public class PageController{

    // Home Page Template
    @GetMapping("/home")
    public String home(
        @RequestParam(required = false) String origin,
        @RequestParam(required = false) String destination,
        Model model) {

            RestTemplate restTemplate = new RestTemplate();
            Airport[] airports = restTemplate.getForObject(ApiEndpoints.Airports.listAllUrl, Airport[].class);
            model.addAttribute("airports", airports);
            return "home";


            
    }
}