package com.example.Taxinator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
public class Kommun {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @Column(name = "TAXRATE")
    private BigDecimal taxRate;
    @Column(name = "CHURCHMEMBER")
    private boolean churchMember;
    @Column(name = "SALARY") @NotNull @Positive
    private BigDecimal salary;

    public Kommun(Long id, String name, BigDecimal taxRate, boolean churchMember, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.taxRate = taxRate;
        this.churchMember = churchMember;
        this.salary = salary;
    }


    /*public Kommun(String name, BigDecimal taxRate) {
        this.name = name;
        this.taxRate = taxRate;
    }

     */

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean getChurchMember() {
        return churchMember;
    }

    public void setChurchMember(boolean churchMember) {
        this.churchMember = churchMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
