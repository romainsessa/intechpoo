package com.intech.cardgame.cards;

public abstract class Person extends Card {
	
	private String name;
	
	public Person(String name, int cost) {
		super(cost);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - nom : " + name;
	}

}
