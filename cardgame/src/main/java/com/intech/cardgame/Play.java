package com.intech.cardgame;

import com.intech.cardgame.cards.Card;
import com.intech.cardgame.cards.CardColor;
import com.intech.cardgame.cards.Ground;
import com.intech.cardgame.cards.Healer;
import com.intech.cardgame.cards.Warrior;

public class Play {

	public static void main(String[] args) {

		Ground forest = new Ground(CardColor.v);
		Warrior w1 = new Warrior("W1", 50, 100);
		Healer h1 = new Healer("H1", 20, "Expert healer");

		Game g = new Game(2);

		try {
			g.draw(h1);
			g.draw(w1);
			g.draw(forest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		g.play();
		g.play();
		
		try {
			g.draw(forest);
			g.draw(h1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("---");
		
		for(Card c : g.getHand()) {
			System.out.println(c);
		}

	}

}
