import java.util.*;

public class GameBlackJack {

    public static void main(String[] args) {
        int playersCount = UserInput.getIntInRange("how many players?", 1, 6);

        List<Player> players = new ArrayList<>(playersCount);
        
        for (int i = 0; i < playersCount; i++) {
            System.out.println("Enter player name");
            players.add(new Player(UserInput.getString()));
        }

        Stack<Card> deck = CardManager.generateDeck();

        for (Player player : players) {
            player.addCard(deck.pop());
            player.addCard(deck.pop());
            String message = player.getName() + ", do you want to take one more card?";

            while ((UserInput.getChoice(message)) && ((player.getScore()) < 21)) {
                player.addCard(deck.pop());

                System.out.println(player.getName() + " score - " + player.getScore());
                if (player.getScore() > 21) {
                    System.out.println(player.getName() + ":you lose");
                }
            }
        }
        GameManager.printResults(players, BotPlayer.getBotResult(deck));
    }
}


