package com.example.Taxinator;

public class Kommun {
   private String name;
    private Double taxRate;

    public Kommun(String name, Double taxRate) {
        this.name = name;
        this.taxRate = taxRate;
    }



    public Kommun() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}
