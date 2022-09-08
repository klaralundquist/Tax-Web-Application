package com.example.Taxinator;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

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
    public String startPage(@ModelAttribute Kommun kommun, Model model) {
        model.addAttribute("kommun", kommun);

        repository.applyTax(kommun);
        model.addAttribute("salaryAfterTax", repository.calculator(kommun));

        BigDecimal bigDecimal = kommun.getTaxRate();
        Double taxRate = bigDecimal.doubleValue();
        Double percentageOfTax = (1-taxRate) * 100;
        //BigDecimal percentage = BigDecimal.valueOf(percentageOfTax);
        BigDecimal test = BigDecimal.valueOf(Precision.round(percentageOfTax, 2));

        model.addAttribute("percentage", test);
        model.addAttribute("kommuner", repository.getKommuner());
        return "home";
    }


}
