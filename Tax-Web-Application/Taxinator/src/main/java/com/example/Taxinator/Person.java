package com.example.Taxinator;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salaryAfterTax;

    @Column(name="CHURCHMEMBER")
    private boolean churchMember;
    @Column(name="SALARY")
    private BigDecimal salary;

    @ManyToOne
    private Kommun kommun;

    public Person() {

    }

    public Person(Long id, BigDecimal salaryAfterTax, boolean churchMember, BigDecimal salary) {
        this.id = id;
        this.salaryAfterTax = salaryAfterTax;
        this.churchMember = churchMember;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalaryAfterTax() {
        return salaryAfterTax;
    }

    public void setSalaryAfterTax(BigDecimal salaryAfterTax) {
        this.salaryAfterTax = salaryAfterTax;
    }

    public boolean getChurchMember() {
        return churchMember;
    }

    public void setChurchMember(boolean churchMember) {
        this.churchMember = churchMember;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Kommun getKommun() {
        return kommun;
    }

    public void setKommun(Kommun kommun) {
        this.kommun = kommun;
    }
}
