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

    @Autowired
    KommunService kommunService;

    @Test
    void test1() {
        Person person1 = new Person(1L, new BigDecimal ("0"), false, new BigDecimal("10000"));
        Kommun kommun1 = new Kommun(1L, "Österåker", new BigDecimal("0.7102"));

        //Test med heltal som resultat.

        Assertions.assertEquals(7102, kommunService.calculator(person1, kommun1));
    }

    @Test
    void test2() {
        Person person2 = new Person(2L, new BigDecimal("0"), false, new BigDecimal("25857"));
        Kommun kommun2 = new Kommun(2L, "Solna", new BigDecimal("0.708"));

        //Test med decimaltal som avrundas uppåt som resultat.

        Assertions.assertEquals(18306.8, kommunService.calculator(person2, kommun2));
    }


    @Test
    void test3() {
        Person person3 = new Person (3L, new BigDecimal("0"), false, new BigDecimal("0"));

        Kommun kommun3 = new Kommun(3L, "Täby", new BigDecimal("0.7037"));

        //Test med noll som input och resultat.

        Assertions.assertEquals(0, kommunService.calculator(person3, kommun3));
    }



    @Test
    void test4() {
        Person person4 = new Person(4L, new BigDecimal("0"), false, new BigDecimal("0"));

        //Test för kyrkoskatt true or false.
        Assertions.assertEquals(false, person4.getChurchMember());
        person4.setChurchMember(true);
        Assertions.assertEquals(true, person4.getChurchMember());
    }
}
