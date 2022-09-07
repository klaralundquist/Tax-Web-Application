package com.example.Taxinator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaxinatorController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @PostMapping("/")
    public String startPage(){
        return "home";
    }

}
