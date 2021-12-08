package wcs.blackjack;

import java.util.Scanner;

public class Game {
	
	Deck gameDeck = new Deck();
	Deck playerDeck = new Deck();
	Deck dealerDeck = new Deck();
	boolean isContinue = true;
	Scanner playerInput = new Scanner(System.in);
	boolean isNewGame = false;
	
	
	public void initializationPlayers() {
		//Gaming deck settings
		gameDeck.createFullDeck();
		gameDeck.shuffleDeck();
		
		// player settings
		playerDeck.draw(gameDeck);
		playerDeck.draw(gameDeck);
				
				
		//Dealer settings
		dealerDeck.draw(gameDeck);
		dealerDeck.draw(gameDeck);
	}
	
	public void resume() {
		System.out.println("Joueur : ");
		playerDeck.printDeck();
		System.out.println("Total actuel : " + playerDeck.cardsValue() + "\n");
		
		System.out.println("Croupier : ");
		System.out.println(dealerDeck.getCard(0) + "\n[Carte chachée]");
		System.out.println("Total actuel : " + (dealerDeck.cardsValue()- dealerDeck.cardValue(dealerDeck.getCard(1))) + "\n");
	}
	
	public void drawResponse() {
		this.playerDeck.draw(gameDeck);
        System.out.println("Vous tirez la carte : " + playerDeck.getCard(playerDeck.deckSize()-1).toString() + "\n----------");
	        
        if(playerDeck.cardsValue() > 21) {
        	 System.out.println("Total actuel : " + playerDeck.cardsValue() + ". Tu as dépassé 21. Tu as perdu... (é^è)");
        } else {
        	this.resume();
        }
	}
	
	public void standResponse() {
		System.out.println("Le croupier révèle sa carte caché");
		dealerDeck.printDeck();
		System.out.println("Total actuel : " + dealerDeck.cardsValue() + "\n");
		
		while (dealerDeck.cardsValue() < 16) {
			System.out.println("Le croupier tire une carte.");
			dealerDeck.draw(gameDeck);
			dealerDeck.printDeck();
    		System.out.println("Total actuel : " + dealerDeck.cardsValue() + "\n");
		}
		
		if (dealerDeck.cardsValue() > 21) {
			System.out.println("Le croupier a dépassé 21. Tu as gagné ! (^o^)");
		} else {
			if (playerDeck.cardsValue() > dealerDeck.cardsValue()) {
				System.out.println("Tu as gagné ! (^o^)");
			} else if (playerDeck.cardsValue() == dealerDeck.cardsValue()) {
				System.out.println("Égalité. Chacun reprend sa mise. (°o°)");
			}else {
				System.out.println("Tu as perdu... (é^è)");
			}
		}
	}
	
	public void decisionPlayer() {
        System.out.println("Que souhaitez-vous faire ? \n (1) Tirer \n (2) Rester \nVotre choix : ");
        
        int response = this.playerInput.nextInt();
        
        if (response == 2) {
        	this.isContinue = false;
        } else {
        	this.drawResponse();
        }
	}
	
	
	public void newGame() {
		System.out.println("Voulez-vous rejouer ? \n (1) Oui \n (2) Non \n");
		int response = this.playerInput.nextInt();
		
		if(response == 1) {
			gameDeck.clearDeck();
			playerDeck.clearDeck();
			dealerDeck.clearDeck();
			this.isNewGame = false;
		} else {
			this.isNewGame = true;
		}
	}
	
}
