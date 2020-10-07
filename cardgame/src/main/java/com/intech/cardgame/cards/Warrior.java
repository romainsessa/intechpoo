package com.intech.cardgame.cards;

public class Warrior extends Person {

	private int damagePoints;
	private int lifePoints;
	
	public Warrior(String name, int damagePoints, int lifePoints) {
		super(name, 50);
		this.damagePoints = damagePoints;
		this.lifePoints = lifePoints;	
	}

	@Override
	public String toString() {
		return super.toString() + " - points de dégats : " + damagePoints + " - points de vie : " + lifePoints;
	}
	
	
}
