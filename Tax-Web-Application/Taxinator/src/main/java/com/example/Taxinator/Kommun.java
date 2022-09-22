package com.example.Taxinator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kommun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String name;
   @Column(name="TAXRATE")
   private BigDecimal taxRate;

   @OneToMany(mappedBy = "kommun", cascade = CascadeType.ALL)
   private List<Person> persons = new ArrayList<>();


    public Kommun(Long id, String name, BigDecimal taxRate) {
        this.id = id;
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

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
