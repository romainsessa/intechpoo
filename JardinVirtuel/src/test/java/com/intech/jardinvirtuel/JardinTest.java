package com.intech.jardinvirtuel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jardin.Jardin;

public class JardinTest {

	@Test
	void testAjouterPanierVide() {
		//Arrange
		Jardin j = new Jardin(5, 5);
		String vegetal = "Tomate";
		
		//Act
		j.ajouterPanier(vegetal, 5);
		int res = j.getPanier().get(vegetal);
		
		//Assert
		assertEquals(5, res);
	}
	
	@Test
	void testAjouterPanierExistant() {
		//Arrange
		Jardin j = new Jardin(5, 5);
		String vegetal = "Tomate";
		j.ajouterPanier(vegetal, 2);
		
		//Act
		j.ajouterPanier(vegetal, 5);
		int res = j.getPanier().get(vegetal);
		
		//Assert
		assertEquals(7, res);
	}
	
	
	
	
}
