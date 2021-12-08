package wcs.blackjack;

public class BlackJack {

	public static void main(String[] args) {
		
		Game game = new Game();
		
		System.out.println("Bienvenue au BLACKJACK !\n");
	
		do {
			game.initializationPlayers();
			game.resume();
			
			while (game.playerDeck.deckSize() < 4 && game.isContinue && game.playerDeck.cardsValue() <= 21){
				game.decisionPlayer();
			}
			
			
			
			if (game.playerDeck.cardsValue()<= 21) {
				game.standResponse();
			}
			
			System.out.println("----------");
			game.newGame();
		}
		while (!game.isNewGame);
		
		System.out.println("Ok. À la prochaine !");
		
		game.playerInput.close();
	}

}
