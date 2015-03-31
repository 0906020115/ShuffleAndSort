package RGA.yzhan222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
	private List<Card> _cards;
	
	public Deck() {
		_cards = new ArrayList<Card>();
		
		for (Suit suit : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(suit, i);
				_cards.add(card);
			}
		}
	}
	
	
	
	public List<Card> get_cards() {
		return _cards;
	}



	public void set_cards(List<Card> _cards) {
		this._cards = _cards;
	}
	
	public Card getByOrder(int order) {
		return _cards.get(order);
	}



	public void printDeck() {
		System.out.println("========= Deck ==========");
		for (Card card : _cards) {
			System.out.println("Suit: " + card.getSuit() + ", Number: " + card.getNumber());
		}
		System.out.println("=========================\n");
	}
	
	public void shuffle() {
		
		for (int i = 0; i < _cards.size(); i++) {
			int index = (int) (Math.random() * (_cards.size() - i)) + i;
			Card sourceCard = _cards.get(i);
			Card targetCard = _cards.get(index);
			Card temp = new Card(sourceCard.getSuit(), sourceCard.getNumber());
			sourceCard.setSuit(targetCard.getSuit());
			sourceCard.setNumber(targetCard.getNumber());
			targetCard.setSuit(temp.getSuit());
			targetCard.setNumber(temp.getNumber());
		}
	}
	
	public List<Card> getCardsWithSameSuit(Suit suit) {
		List<Card> cards = new ArrayList<Card>();
		for (Card card : _cards) {
			if (card.getSuit().equals(suit)) {
				cards.add(card);
			}
		}
		
		return cards;
	}
	
	public void orderCards() {
		List<Card> cards = new ArrayList<Card>();
		
		Card[] spadeCards = new Card[13];
		Card[] heartCards = new Card[13];
		Card[] diamondCards = new Card[13];
		Card[] clubCards = new Card[13];
		
		for (Card card : _cards) {
			if (card.getSuit().equals(Suit.SPADE)) {
				int number = card.getNumber();
				spadeCards[number - 1] = card;
			}
			else if (card.getSuit().equals(Suit.HEART)) {
				int number = card.getNumber();
				heartCards[number - 1] = card;
			}
			else if (card.getSuit().equals(Suit.DIAMOND)) {
				int number = card.getNumber();
				diamondCards[number - 1] = card;
			}
			else if (card.getSuit().equals(Suit.CLUB)) {
				int number = card.getNumber();
				clubCards[number - 1] = card;
			}
			else {
				throw new RuntimeException("unsupported card type: " + card.getSuit());
			}
		}
		
		cards.addAll(Arrays.asList(diamondCards));
		cards.addAll(Arrays.asList(clubCards));
		cards.addAll(Arrays.asList(heartCards));
		cards.addAll(Arrays.asList(spadeCards));
		
		_cards = cards;
	}
	
	public void printCards(List<Card> cards) {
		System.out.println("========= Cards ==========");
		for (Card card : cards) {
			System.out.println("Suit: " + card.getSuit() + ", Number: " + card.getNumber());
		}
		System.out.println("==========================\n");
	}
}
