package RGA.yzhan222;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DeckTest {
	List<Card> cards = mock(List.class);
	Card card = mock(Card.class);
	Deck deck = new Deck(); 
	
	@Before
	public void init() {
		deck.set_cards(cards);
		
		when(cards.size()).thenReturn(52);
		when(cards.get(Mockito.anyInt())).thenReturn(card);
		when(card.getSuit()).thenReturn(Suit.HEART);
		when(card.getNumber()).thenReturn(1);
		
		
	}
	
	@Test
	public void test() {
		deck.shuffle();
		
		verify(card, times(104)).setNumber(Mockito.anyInt());
		
	}
	
	@Test
	public void testOrder() {
		deck = new Deck();
		deck.shuffle();
		deck.orderCards();
		Card card = deck.getByOrder(14);
		assertEquals(card.getSuit(), Suit.CLUB);
		assertEquals(card.getNumber(), 2);
	}
	
	
}
