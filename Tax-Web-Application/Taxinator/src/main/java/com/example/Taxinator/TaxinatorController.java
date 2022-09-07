package com.example.Taxinator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxinatorController {
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("kommun", new Kommun());
        return "home";
    }
    @PostMapping("/")
    public String startPage(@ModelAttribute Kommun kommun, Model model){
        model.addAttribute("kommun", kommun);
        return "home";
    }

}
