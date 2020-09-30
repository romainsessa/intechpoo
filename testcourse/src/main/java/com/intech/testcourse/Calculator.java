package com.intech.testcourse;

public class Calculator {
	
	public int addition(int x, int y) {
		return x+y;
	}
	
	public int multiplication(int x, int y) {
		return x*y;
	}
	
	public int soustraction(int x, int y) {	
		
		if(y > x) {
			return 0;
		}
		return x-y;
	}

}