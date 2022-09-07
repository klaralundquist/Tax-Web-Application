package com.example.Taxinator;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class KommunRepository {
      private List<Kommun> kommuner;


            public Double calculator(Kommun kommun, Double userInput){
              Double result;
              Double churchTax=0.0025;

              if(kommun.isChurchMember){result=(userInput*churchTax)*kommun.getTaxRate();

              }result=userInput*kommun.getTaxRate();
            return result;}
}

