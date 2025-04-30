package com.backend.cheapflights;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

// Views templates
@Controller
public class PageController{
    // Home Page Template
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Dear User");
        return "home";
    }
}