package RGA.yzhan222;

public class Card {
	private Suit _suit;
	private int _number;
	
	public Card(Suit suit, int number) {
		_suit = suit;
		_number = number;
	}
	
	public Suit getSuit() {
		return _suit;
	}
	
	public int getNumber() {
		return _number;
	}
	
	public void setSuit(Suit suit) {
		_suit = suit;
	}
	
	public void setNumber(int number) {
		_number = number;
	}
}
