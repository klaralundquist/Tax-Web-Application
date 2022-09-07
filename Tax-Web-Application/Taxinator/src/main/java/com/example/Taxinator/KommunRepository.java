package com.example.Taxinator;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KommunRepository {
      private List<Kommun> kommuner;

      public KommunRepository() {
            kommuner = new ArrayList<>();
            kommuner.add(new Kommun("Österåker", 0.7102));
            kommuner.add(new Kommun("Solna", 0.708));
            kommuner.add(new Kommun("Täby", 0.7037));
            kommuner.add(new Kommun("Stockholm", 0.7018));
            kommuner.add(new Kommun("Huddinge", 0.6845));
      }

      public List<Kommun> getKommuner () {
            return kommuner;
}

      public Double calculator(Kommun kommun, Double userInput) {
            Double result;
            final Double churchTax = 0.0025;

            if (kommun.isChurchMember()) {
                  result = (userInput * churchTax) * kommun.getTaxRate();
            } else {
                  result = userInput * kommun.getTaxRate();
            }
            return result;
      }
}
