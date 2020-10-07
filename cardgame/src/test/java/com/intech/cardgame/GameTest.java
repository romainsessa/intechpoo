package com.intech.cardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.intech.cardgame.cards.Card;
import com.intech.cardgame.cards.CardColor;
import com.intech.cardgame.cards.Ground;
import com.intech.cardgame.cards.Healer;
import com.intech.cardgame.cards.Warrior;

public class GameTest {
	
	private static Warrior w;
	private static Healer h;
	private static Ground gr;
	
	@BeforeAll
	public static void init() {
		gr = new Ground(CardColor.v);
		w = new Warrior("W1", 10, 20);
		h = new Healer("H1", 10, "...");
	}
	
	@Test
	public void testDraw() {
		//Arrange
		Game g = new Game(3);
		
		//Act
		try {
			g.draw(gr);
		} catch (Exception e) {

		}

		Card[] cards = g.getHand();
		
		//Assert	
		assertEquals(gr, cards[0]);
	}
	
	@Test
	public void testFullHand() {
		//Arrange
		Game g = new Game(1);		
		
		//Act
		try {
			g.draw(gr);
			g.draw(w);
			fail();
		} catch (Exception e) {
			// Assert
			assertEquals("Card game FULL", e.getMessage());
		}

	}	
	
	@Test
	public void testPlay() throws Exception {
		//Arrange
		Game g = new Game(3);
				
		//Act
		g.draw(h);
		g.draw(gr);
		g.play();
		Card[] cards = g.getHand();
		
		//Assert	
		assertNull(cards[0]);
		assertNotNull(cards[1]);
	}

}
