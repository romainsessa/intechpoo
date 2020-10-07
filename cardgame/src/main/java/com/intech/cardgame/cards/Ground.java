package com.intech.cardgame.cards;

public class Ground extends Card {

	private CardColor color;
	
	public Ground(CardColor color) {
		super(0);
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " - couleur : " + color;
	}
	
}
