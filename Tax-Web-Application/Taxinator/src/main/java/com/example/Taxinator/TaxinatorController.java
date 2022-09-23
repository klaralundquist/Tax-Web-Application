package com.example.Taxinator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public String homePage(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("kommun", new Kommun());
        model.addAttribute("kommuner", (List) repository.findAll());
        return "home";
    }

    @PostMapping("/result")
    public String startPage(@Valid Person person, BindingResult resultPerson, @Valid Kommun kommun, BindingResult resultKommun, Model model, HttpSession session) {
        model.addAttribute("kommuner", (List) repository.findAll());

        if (resultKommun.hasErrors() || resultPerson.hasErrors()) {
            return "home";
        }

        kommunService.applyTax(kommun);

        model.addAttribute("salaryAfterTax", kommunService.calculator(person, kommun));
        person.setSalaryAfterTax(BigDecimal.valueOf(kommunService.calculator(person, kommun)));
        Double taxRate = kommunService.getPercentageOfTax(kommun);

        model.addAttribute("percentage", taxRate);

        List<Person> personList = (List<Person>) session.getAttribute("personList");
        List<Kommun> kommunList = (List<Kommun>) session.getAttribute("kommunList");

        if (kommunList == null && personList == null) {
            personList = new ArrayList<>();
            kommunList = new ArrayList<>();
            session.setAttribute("personList", personList);
            session.setAttribute("kommunList", kommunList);
        }
        personList.add(person);
        kommunList.add(kommun);

        return "result";
    }

    @GetMapping("/historik")
    public String historik() {
        return "historik";
    }

    @PostMapping("/historik")
    public String historik(@Valid Person person, @Valid Kommun kommun, HttpSession session, Model model) {
        List<Kommun> kommunList = (List<Kommun>) session.getAttribute("kommunList");
        List<Person> personList = (List<Person>) session.getAttribute("personList");

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
