package wcs.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	//Variables
	private ArrayList<Card> cards;

	//Constructor
	public Deck() {
		this.cards = new ArrayList<>();
	}
	
	public void createFullDeck(){
		//Generate card by suit...
		for (Color cardColor : Color.values()) {
			//and by value
			for(Name cardName : Name.values()) {
				//Add new card on the deck
				this.cards.add(new Card(cardName, cardColor));
			}
		}
	}

	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public void removeCard(int index) {
		this.cards.remove(index);
	}
	
	public Card getCard(int index) {
		return this.cards.get(index);
	}
	
	//Draw the first card on the deck game
	public void draw(Deck gameDeck) {
		this.cards.add(gameDeck.getCard(0));
		gameDeck.removeCard(0);
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public int cardValue(Card card) {
		int cardValue = 0;
		
		switch (card.getName()) {
		case DEUX: cardValue = 2; break;
		case TROIS: cardValue = 3; break;
		case QUATRE: cardValue = 4; break;
		case CINQ: cardValue = 5; break;
		case SIX: cardValue = 6; break;
		case SEPT: cardValue = 7; break;
		case HUIT: cardValue = 8; break;
		case NEUF: cardValue = 9; break;
		case DIX: cardValue = 10; break;
		case VALET: cardValue = 10; break;
		case DAME: cardValue = 10; break;
		case ROI: cardValue = 10; break;
		case ACE: cardValue = 11; break;
		}
		
		return cardValue;
	}
	
	public int cardsValue() {
		int totalValue = 0;
		
		for (Card card : this.cards) {
			totalValue += this.cardValue(card);
		}
		
		return totalValue;
	}
	
	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}
	
	public void clearDeck() {
		this.cards.clear();
	}
	

}
