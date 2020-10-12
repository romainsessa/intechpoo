package com.intech.jardinfx.model;

public class Emplacement {

	private Vegetal veg;
	
	public Vegetal getVeg() {
		return veg;
	}
	
	public Emplacement(Vegetal v) {
		this.veg = v;
	}
	
	@Override
	public String toString() {
		return veg.toString();
	}
	
}
