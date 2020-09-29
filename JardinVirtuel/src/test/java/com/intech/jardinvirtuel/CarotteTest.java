package com.intech.jardinvirtuel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jardin.Jardin;
import jardin.flore.Carotte;

public class CarotteTest {
	
	@Test
	void testSeReproduire() {
		//Arrange
		Jardin j = new Jardin(10,10);
		String vegetal = "Carotte";
		j.ajouterPanier(vegetal, 2);
		Carotte a = new Carotte();	
		
		//Act
		a.seReproduire(j.getPanier());
		int res = j.getPanier().get(vegetal);
		
		//Assert
		assertEquals(5, res);
		
	}

}
