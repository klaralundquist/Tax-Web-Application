package com.example.Taxinator;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class TaxinatorController {
    @Autowired
    KommunRepository repository;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("kommun", new Kommun());
        model.addAttribute("kommuner", (List)repository.findAll());
        return "home";
    }
    @PostMapping("/")
    public String startPage(@ModelAttribute Kommun kommun, Model model, HttpSession session) {
        model.addAttribute("kommun", kommun);
        applyTax(kommun);

        model.addAttribute("salaryAfterTax", calculator(kommun));
        Double taxRate = getPercentageOfTax(kommun);

        model.addAttribute("percentage", taxRate);
        model.addAttribute("kommuner", (List)repository.findAll());

        List<Kommun> kommunList = (List<Kommun>)session.getAttribute("kommunList");

        if (kommunList == null) {
            kommunList = new ArrayList<>();
            session.setAttribute("kommunList", kommunList);
        }
        kommunList.add(kommun);

        return "home";
    }
    @GetMapping ("/historik")
    public String historik() {
        return "historik";
    }
    @PostMapping ("/historik")
    public String historik(@ModelAttribute Kommun kommun, HttpSession session) {
        List<Kommun> kommunList = (List<Kommun>)session.getAttribute("kommunList");

        if (kommunList == null) {
            kommunList = new ArrayList<>();
            session.setAttribute("kommunList", kommunList);
        }
        kommunList.add(kommun);
        Double test = calculator(kommunList.get(1));
        session.setAttribute("salaryAfterTax", test);

        return "historik";
    }

    public Double calculator(Kommun kommun) {
        double result;
        final BigDecimal churchTax = new BigDecimal("0.9975");

        if (kommun.getChurchMember()) {
            result = kommun.getTaxRate().multiply(kommun.getSalary().multiply(churchTax)).doubleValue();
        } else {
            result = kommun.getSalary().multiply(kommun.getTaxRate()).doubleValue();
        }
        return Precision.round(result, 1);
    }
    public Double getPercentageOfTax(Kommun kommun) {
        BigDecimal taxRate = kommun.getTaxRate();
        Double taxRate2 = taxRate.doubleValue();
        Double percentageOfTax = (1-taxRate2) * 100;
        BigDecimal finalPercentageOfTax = BigDecimal.valueOf(Precision.round(percentageOfTax, 2));

        return finalPercentageOfTax.doubleValue();
    }


    public Kommun applyTax(Kommun kommun) {
        List<Kommun> kommuner = (List<Kommun>)repository.findAll();
        for (int i = 0; i < kommuner.size(); i++) {

            if(kommun.getName().equals(kommuner.get(i).getName())) {
                kommun.setTaxRate(kommuner.get(i).getTaxRate());
                return kommun;
            }
        }
        return null;

    }

}
