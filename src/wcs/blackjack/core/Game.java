package wcs.blackjack.core;

import java.util.Scanner;

import wcs.blackjack.core.model.Deck;
import wcs.blackjack.core.model.Player;

public class Game {
	
	private Scanner sc;
	
	public Game() {
		//System.in = entrée du clavier
		this.sc = new Scanner(System.in);
		
	}
	
	public void begin() {
		
		
		do {
			//Creation d'un deck
			//Mélanger les cartes
			Deck deck = new Deck();
			
			//Creation d'un joueur et du croupier
			Player player = new Player(this.askPlayername());
			Player dealer = new Player("Croupier");
			
			//Distribution de deux cartes au joueur
			player.hitCardAndSetScore(deck.getCard());
			player.hitCardAndSetScore(deck.getCard());

			//Distribution de deux cartes au croupier
			dealer.hitCardAndSetScore(deck.getCard());
			dealer.hitCardAndSetScore(deck.getCard());

			
			//Afficher les cartes du joueur + valeurs
			player.showHandAndScore();
			//Afficher les cartes du croupier + valeurs
			dealer.showHandAndScore();
			
			
			//(Optionnel) Si BlacJack direct, calcul des scores et arrêt du jeu 

			//Proposer au joueur de Tirer ou Rester
			//Tant que le joueur Tire et moins de 4 cartes,
			while(player.getScore() < 21 && player.getHand().size() < 4 && this.wantToHit()){
				//On lui donne une carte
				//On retire cette carte du deck
				player.hitCardAndSetScore(deck.getCard());
				//On affiche sa main et son score
				player.showHandAndScore();
			}

			
			//Si le joueur a plus de 21, arrêt du jeu
			if(!this.instantLoose(player)) {
				//Tant que le croupier a moins 16
				while (dealer.getScore() < 16) {
					//Il tire une carte
					//On retire cette carte du deck
					dealer.hitCardAndSetScore(deck.getCard());			
				}
				
				//On affiche sa main et son score
				dealer.showHandAndScore();
			
				//Si le croupier a plus de 21, arrêt du jeu
				if (!this.instantLoose(dealer)) {
					//Comparaison des scores (égalité, joueur gagne, croupier gagne)
					this.showWinner(player, dealer);
				}
			}
		//Proposer de rejouer
		}while(this.wantToPlayAgain());
		
		
		
		
		
		
	}


	private boolean wantToPlayAgain() {
		String answer;
		do {
			System.out.println("Voulez-vous rejouer ? (O)ui ou (N)on");
			answer = this.sc.next();
			
		}while(answer.toLowerCase().charAt(0) != 'o' && answer.toLowerCase().charAt(0) != 'n');
		
		return answer.toLowerCase().charAt(0) == 'o';
	}

	private void showWinner(Player player, Player dealer) {
		if(player.getScore() < dealer.getScore()) {
			System.out.printf("%s a gagné ! (é^è) %n", dealer.getName());
			
		}else if(player.getScore() > dealer.getScore()) {
			System.out.printf("%s a gagné ! (^-^) %n", player.getName());
			
		} else if (player.getScore() == dealer.getScore()) {
			System.out.printf("%s et %s sont à égalité. (°o°) %n", player.getScore(), dealer.getScore());

		}
		
	}

	private boolean instantLoose(Player player) {
		if(player.getScore() > 21) {
			System.out.printf("%s a perdu pour avoir dépassé 21 points. (%d points) %n", player.getName(), player.getScore());
			return true;
		}
		return false;
	}

	private String askPlayername() {
		String namePlayer;
		
		do {
			System.out.println("Entrez votre nom : ");
			namePlayer = this.sc.next();
		}while(namePlayer.isBlank());

		return namePlayer;
	}
	
	/*
	 * @return : true si le joueur veut tirer
	 */
	private boolean wantToHit() {
		String answer;
		do {
			System.out.println("Voulez-vous (T)irer ou(R)ester ?");
			answer = this.sc.next();
			
		}while(answer.toLowerCase().charAt(0) != 't' && answer.toLowerCase().charAt(0) != 'r');
		
		return answer.toLowerCase().charAt(0) == 't';
	}
	
	

}
