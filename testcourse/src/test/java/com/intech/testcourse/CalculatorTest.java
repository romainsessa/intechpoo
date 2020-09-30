package com.intech.testcourse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	// L'attribut c doit être static car il est utilisé par les méthodes init et clode qui sont static.
	private static Calculator c;
	
	@BeforeAll
	static void init() {
		c = new Calculator();
		System.out.println("Cette méthode s'exécute une fois avant tous les tests.");
	}
	
	@BeforeEach
	void before() {
		System.out.println("Cette méthode s'exécute avant chaque test.");
	}
	
	@AfterEach
	void after() {
		System.out.println("Cette méthode s'exécute après chaque test.");
	}
	
	
	@AfterAll
	static void close() {
		c = null;
		System.out.println("Cette méthode s'exécute une fois après tous les tests.");
	}

	@Test
	void testAddition() {
		//Arrange
		int x = 2;
		int y = 3;
		
		//Act
		int result = c.addition(x, y);
		
		//Assert
		assertEquals(5, result);
	}
	
	@Test
	void testMultiplication() {
		//Arrange
		c = new Calculator();
		int x = 3;
		int y = 4;
		
		//Act
		int result = c.multiplication(x, y);
		
		//Assert
		assertEquals(12, result);
	}
	
	@Test
	void testSoustractionPositive() {
		//Arrange
		c = new Calculator();
		int x = 3;
		int y = 1;
		
		//Act
		int result = c.soustraction(x, y);
		
		//Assert
		assertEquals(2, result);
	}
	
	@Test
	void testSoustractionNegative() {
		//Arrange
		int x = 1;
		int y = 2;
		
		//Act
		int result = c.soustraction(x, y);
		
		//Assert
		assertEquals(0, result);
	}

}
