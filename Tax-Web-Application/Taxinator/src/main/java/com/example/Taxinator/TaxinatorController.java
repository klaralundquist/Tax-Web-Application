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

    @Autowired
    KommunService kommunService;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("kommun", new Kommun());
        model.addAttribute("kommuner", (List)repository.findAll());
        return "home";
    }
    @PostMapping("/")
    public String startPage(@ModelAttribute Person person, @ModelAttribute Kommun kommun, Model model, HttpSession session) {
        //model.addAttribute("kommun", kommun);
        kommunService.applyTax(kommun);

        model.addAttribute("salaryAfterTax",kommunService.calculator(person, kommun));
        person.setSalaryAfterTax(BigDecimal.valueOf(kommunService.calculator(person,kommun)));
        Double taxRate = kommunService.getPercentageOfTax(kommun);

        model.addAttribute("percentage", taxRate);
        model.addAttribute("kommuner", (List)repository.findAll());

        List<Person> personList = (List<Person>)session.getAttribute("personList");
        List<Kommun> kommunList = (List<Kommun>)session.getAttribute("kommunList");

        if (kommunList == null && personList == null) {
            personList = new ArrayList<>();
            kommunList = new ArrayList<>();
            session.setAttribute("personList", personList);
            session.setAttribute("kommunList", kommunList);
        }
        personList.add(person);
        kommunList.add(kommun);

        return "home";
    }
    @GetMapping ("/historik")
    public String historik() {
        return "historik";
    }
    @PostMapping ("/historik")
    public String historik(@ModelAttribute Person person, @ModelAttribute Kommun kommun, HttpSession session, Model model) {
        List<Kommun> kommunList = (List<Kommun>)session.getAttribute("kommunList");
        List<Person> personList = (List<Person>)session.getAttribute("personList");

        if (kommunList == null && personList == null) {
            kommunList = new ArrayList<>();
            personList = new ArrayList<>();
            session.setAttribute("personList", personList);
            session.setAttribute("kommunList", kommunList);

        }

        kommunList.add(kommun);
        personList.add(person);

        return "historik";
    }

}
