package wcs.blackjack.core.model;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
		this.score = 0;
	}
	
	public void hitCardAndSetScore(Card card) {
		this.getHand().add(card);
		//MAJ du score grâce au point de la carte
		this.setScore(this.getScore() + card.getPoints());
	}
	
	public void showHandAndScore() {
		System.out.printf("Main de %s (%d points) : %n", this.getName(), this.getScore());
		for(Card card : this.getHand()) {
			System.out.println(card.toString());
		}
	}
	
	public void showFirstCard() {
		System.out.printf("Main de %s (%d points) : %n", this.getName(), this.getHand().get(0).getPoints());
		System.out.println(this.getHand().get(0).toString());
	}
	

	public String getName() {
		return name;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	}
