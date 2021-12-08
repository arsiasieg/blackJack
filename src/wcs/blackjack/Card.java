package wcs.blackjack;

public class Card {
	
	//Variables
	private Name name;
	private Color color;
	
	//Constructor
	public Card(Name name, Color color) {
		this.color = color;
		this.name = name;
	}
	
	//Return the card suit and value
	public String toString() {
		return this.name.toString().toLowerCase() + " de " + this.color.toString().toLowerCase();
	}
	
	public Name getName() {
		return this.name;
	}
	
}
