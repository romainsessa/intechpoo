package com.intech.cardgame.cards;

public class Healer extends Person {
	
	private int carePoints;
	private String description;
	
	public Healer(String name, int carePoints, String description) {
		super(name, 10);		
		this.carePoints = carePoints;
		this.description = description;
	}

	@Override
	public String toString() {
		return super.toString() + " - points de soin : " + carePoints + " - description : " + description;
	}

}
