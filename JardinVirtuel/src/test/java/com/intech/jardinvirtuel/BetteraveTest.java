package com.intech.jardinvirtuel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.AbstractMap.SimpleEntry;

import org.junit.jupiter.api.Test;

import jardin.flore.Betterave;
import jardin.flore.Etat;

public class BetteraveTest {

	@Test
	void testSeDupliquer() {
		//Arrange
		Betterave b = new Betterave();
		
		//Act
		SimpleEntry<Integer, Integer> res = b.seDupliquer(5, 5);
		
		//Assert
		assertTrue(res.getKey() >= 0 && res.getKey()<5);
		assertTrue(res.getValue() >= 0 && res.getValue()<5);
		assertEquals(Etat.GRAINE, b.getEtat());
	}
	
}
