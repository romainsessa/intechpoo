package com.intech.jardinvirtuel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jardin.Jardin;
import jardin.flore.Ail;

public class AilTest {
	
	@Test
	void testSeReproduire() {
		//Arrange
		Jardin j = new Jardin(10,10);
		String vegetal = "Ail";
		j.ajouterPanier(vegetal, 2);
		Ail a = new Ail();	
		
		//Act
		a.seReproduire(j.getPanier());
		int res = j.getPanier().get(vegetal);
		
		//Assert
		assertEquals(5, res);
		
	}

}
