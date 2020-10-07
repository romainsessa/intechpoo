package com.intech.cardgame.cards;

public abstract class Card implements ICard {

	private int cost;
	
	public Card(int cost) {
		this.cost = cost;
		System.out.println(this.getClass().getSimpleName());
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " -  cout : " + cost;
	}
	
	
}
