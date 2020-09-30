package com.intech.testcourse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileServiceTest {

	/**
	 * La méthode getInfo va lire un fichier dont le chemain est "c:/test.txt"
	 * Dans mon cas ce fichier contient le texte romainsessa
	 * Le texte "expected" est donc romainsessa
	 */
	@Test
	void testGetInfo() {
		//Arrange 
		FileService f = new FileService();
		
		//Act
		String res = f.getInfo();
		
		//Assert
		assertEquals("romainsessa", res);
	}
	
	@Test
	void testGetInfoWithInvalidPath() {
		//Arrange 
		FileService f = new FileService();
		f.setPath("x:/test.txt");
		
		//Act
		String res = f.getInfo();
		
		//Assert
		assertEquals("", res);
	}
	
}
