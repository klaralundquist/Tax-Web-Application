package com.example.Taxinator;

import java.math.BigDecimal;

public class Kommun {
   private String name;
   private BigDecimal taxRate;
   private boolean isChurchMember;

    public Kommun(String name, BigDecimal taxRate) {
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

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public boolean isChurchMember() {
        return isChurchMember;
    }

    public void setChurchMember(boolean churchMember) {
        this.isChurchMember = churchMember;
    }
}
