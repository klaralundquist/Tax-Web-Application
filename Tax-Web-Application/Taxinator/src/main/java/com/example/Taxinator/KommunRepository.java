package com.example.Taxinator;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KommunRepository {
      private List<Kommun> kommuner;

      public KommunRepository() {
            kommuner = new ArrayList<>();
            kommuner.add(new Kommun("Österåker", new BigDecimal("0.7102")));
            kommuner.add(new Kommun("Solna", new BigDecimal("0.708")));
            kommuner.add(new Kommun("Täby", new BigDecimal("0.7037")));
            kommuner.add(new Kommun("Stockholm", new BigDecimal("0.7018")));
            kommuner.add(new Kommun("Huddinge", new BigDecimal("0.6845")));
      }

      public List<Kommun> getKommuner () {
            return kommuner;
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
            for (int i = 0; i < getKommuner().size(); i++) {
                  if (kommun.getName().equals(getKommuner().get(i).getName())) {
                        kommun.setTaxRate(getKommuner().get(i).getTaxRate());
                        return kommun;
                  }
            }
            return null;

      }
      public Double getPercentageOfTax(Kommun kommun) {
            BigDecimal taxRate = kommun.getTaxRate();
            Double taxRate2 = taxRate.doubleValue();
            Double percentageOfTax = (1-taxRate2) * 100;
            BigDecimal finalPercentageOfTax = BigDecimal.valueOf(Precision.round(percentageOfTax, 2));

            return finalPercentageOfTax.doubleValue();
      }
}
