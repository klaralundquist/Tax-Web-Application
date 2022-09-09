package com.example.Taxinator;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaxinatorController {
    @Autowired
    KommunRepository repository;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("kommun", new Kommun());
        model.addAttribute("kommuner", repository.getKommuner());
        return "home";
    }
    @PostMapping("/")
    public String startPage(@ModelAttribute Kommun kommun, Model model, HttpSession session) {
        model.addAttribute("kommun", kommun);

        repository.applyTax(kommun);
        model.addAttribute("salaryAfterTax", repository.calculator(kommun));

        Double taxRate = repository.getPercentageOfTax(kommun);

        model.addAttribute("percentage", taxRate);
        model.addAttribute("kommuner", repository.getKommuner());

        return "home";
    }

    @GetMapping ("/skattesatser")
    public String skatteSatser() {
        return "skattesatser";
    }


}
