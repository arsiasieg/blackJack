package wcs.blackjack.core.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		//On génère les cartes et on mélange
		this.generateCards();
	}
	
	private void generateCards() {
		for(EColor color : EColor.values()) {
			for (EName name : EName.values()) {
				this.getCards().add(new Card(name, color, this.getPointsFromName(name)));
			}
		}
		
		Collections.shuffle(this.getCards());
	}
	
	private int getPointsFromName(EName name) {
		int point = 0;
		
		switch (name.name()) {
			case "DEUX" : point = 2; break;
			case "TROIS" : point = 3; break;
			case "QUATRE" : point = 4; break;
			case "CINQ" : point = 5; break;
			case "SIX" : point = 6; break;
			case "SEPT" : point = 7; break;
			case "HUIT" : point = 8; break;
			case "NEUF" : point = 9; break;
			case "VALET", "DAME", "ROI", "DIX" : point = 10; break;
			case "AS": point = 11; break;
			default : throw new IllegalArgumentException("Unexpected value : " + name.name());
		}
		
		return point;
	}
	
	/**
	 * Prend la première carte du deck et l'enlève de celui-ci
	 * @return la carte qui a été pioché
	 */
	public Card getCard() {
		//Remove mais renvoie aussi la carte qu'on remove
		return this.getCards().remove(0);
	}
	
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
		
}


