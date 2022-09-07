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
	void test() {
		Assertions.assertEquals(7102, repository.calculator(new Kommun("Österåker", new BigDecimal("0.7102")), new BigDecimal(10000.0)));
		Assertions.assertEquals(7080, repository.calculator(new Kommun("Solna", new BigDecimal("0.708")), new BigDecimal(10000.0)));
		Assertions.assertEquals(false, new Kommun("Täby", new BigDecimal("0.7037")).isChurchMember());
		Kommun kommun = new Kommun("Täby", new BigDecimal("0.7037"));
		kommun.setChurchMember(true);
		Assertions.assertEquals(true, kommun.isChurchMember());
	}

}
