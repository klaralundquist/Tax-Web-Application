package com.example.Taxinator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class TaxinatorApplicationTests {

	@Autowired
    OldKommunRepository repository;
	@Test
	void test() {

		//Instansiering av kommuner med information från KommunRepository.
		Kommun kommun1 = new Kommun("Österåker", new BigDecimal("0.7102"));
		Kommun kommun2 = new Kommun("Solna", new BigDecimal("0.708"));
		Kommun kommun3 = new Kommun("Täby", new BigDecimal("0.7037"));
		Kommun kommun4 = new Kommun("Stockholm", new BigDecimal("0.7018"));

		//Test med heltal som resultat.
		kommun1.setSalary(new BigDecimal("10000"));
		Assertions.assertEquals(7102, repository.calculator(kommun1));

		//Test med decimaltal som resultat.
		kommun2.setSalary(new BigDecimal("25854"));
		Assertions.assertEquals(18304.632, repository.calculator(kommun2));

		//Test med noll som input och resultat.
		kommun3.setSalary(new BigDecimal("0"));
		Assertions.assertEquals(0, repository.calculator(kommun3));

		//Test för kyrkoskatt true or false.
		Assertions.assertEquals(false, kommun4.getChurchMember());
		kommun4.setChurchMember(true);
		Assertions.assertEquals(true, kommun4.getChurchMember());
	}
}
