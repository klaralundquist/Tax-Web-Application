package com.example.Taxinator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class TaxinatorApplicationTests {

    @Autowired
    KommunRepository repository;

    @Test
    void test1() {
        Kommun kommun1 = new Kommun(1L, "Österåker", new BigDecimal("0.7102"), false, new BigDecimal("0"));

        //Test med heltal som resultat.
        kommun1.setSalary(new BigDecimal("10000"));
        Assertions.assertEquals(7102, TaxinatorController.calculator(kommun1));
    }

    @Test
    void test2() {
        Kommun kommun2 = new Kommun(2L, "Solna", new BigDecimal("0.708"), false, new BigDecimal("0"));

        //Test med decimaltal som avrundas uppåt som resultat.
        kommun2.setSalary(new BigDecimal("25857"));
        Assertions.assertEquals(18306.8, TaxinatorController.calculator(kommun2));
    }

    @Test
    void test3() {
        Kommun kommun3 = new Kommun(3L, "Täby", new BigDecimal("0.7037"), false, new BigDecimal("0"));

        //Test med noll som input och resultat.
        kommun3.setSalary(new BigDecimal("0"));
        Assertions.assertEquals(0, TaxinatorController.calculator(kommun3));
    }

    @Test
    void test4() {
        Kommun kommun4 = new Kommun(4L, "Stockholm", new BigDecimal("0.7018"), false, new BigDecimal("0"));

        //Test för kyrkoskatt true or false.
        Assertions.assertEquals(false, kommun4.getChurchMember());
        kommun4.setChurchMember(true);
        Assertions.assertEquals(true, kommun4.getChurchMember());
    }
}
