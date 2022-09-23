package com.example.Taxinator;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class KommunService {

    @Autowired
    KommunRepository repository;

    public Double calculator(Person person, Kommun kommun) {
        double result;
        final BigDecimal churchTax = new BigDecimal("0.9975");

        if (person.getChurchMember()) {
            result = kommun.getTaxRate().multiply(person.getSalary().multiply(churchTax)).doubleValue();
        } else {
            result = person.getSalary().multiply(kommun.getTaxRate()).doubleValue();
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
