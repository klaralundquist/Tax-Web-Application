package com.example.Taxinator;

public class Kommun {
   private String name;
   private Double taxRate;
   private boolean churchMember;
   private Double salary;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean getChurchMember() {
        return churchMember;
    }

    public void setChurchMember(boolean churchMember) {
        this.churchMember = churchMember;
    }
}
