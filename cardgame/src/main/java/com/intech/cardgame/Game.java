package com.intech.cardgame;

import com.intech.cardgame.cards.Card;

public class Game {
	
	private Card hand[];
	
	
	public Card[] getHand() {
		return hand;
	}
	
	public Game(int nbMaxCard) {
		hand = new Card[nbMaxCard];
	}
	
	public void draw(Card card) throws Exception {
		
		boolean full = true;
		
		for(int i=0; i < hand.length; i++) {
			if(hand[i] == null) {
				hand[i] = card;
				full = false;
				break;
			}
		}
		
		if(full) {
			throw new Exception("Card game FULL");
		}
	}
	
	public void play() {
		
		for(int i=0; i < hand.length; i++) {
			if(hand[i] != null) {
				System.out.println("I play a card...");
				System.out.println(hand[i]);
				hand[i] = null;
				break;
			}
		}
		
	}

}
