package RGA.yzhan222;

import java.util.List;

public class CardGame {
	public static void main(String args[]) {
		Deck deck = new Deck();
		deck.printDeck();
		
		deck.shuffle();
		deck.printDeck();
		
		List<Card> heartCards = deck.getCardsWithSameSuit(Suit.HEART);
		deck.printCards(heartCards);
		
		deck.orderCards();
		deck.printDeck();
		
	}
}
