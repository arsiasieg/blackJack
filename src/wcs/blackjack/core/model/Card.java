package wcs.blackjack.core.model;

public class Card {
	private EName name;
	private EColor color;
	private int points;
	
	public Card(EName name, EColor color, int points) {
		this.name = name;
		this.color = color;
		this.points = points;
	}

	public EName getName() {
		return name;
	}

	public EColor getColor() {
		return color;
	}

	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		return this.getName().name() + " de " + this.getColor().name();
	}
	
	
}
