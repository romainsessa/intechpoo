package com.intech.testcourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	
	private String path = "c:/test.txt";
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getInfo() {
		BufferedReader in;
		String result = "";
		try {
			in = new BufferedReader(new FileReader(path));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Fichier introuvable sur le disque.");
		} catch (IOException e) {
			System.out.println("Une erreur est survenue. " + e.getMessage());
		}
		return result;
	}

}
