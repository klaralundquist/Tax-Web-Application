package com.example.Taxinator;

public class Kommun {
   private String name;
   private Double taxRate;
   private boolean isChurchMember;

    public Kommun(String name, Double taxRate) {
        this.name = name;
        this.taxRate = taxRate;
        this.isChurchMember = isChurchMember();
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

    public boolean isChurchMember() {
        return isChurchMember;
    }

    public void setChurchMember(boolean churchMember) {
        isChurchMember = churchMember;
    }
}
