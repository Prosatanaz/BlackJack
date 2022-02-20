import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
            Card card = deck.pop();
            player.addCard(card);
            CardManager.printCardStats(card);

            card = deck.pop();
            player.addCard(card);
            CardManager.printCardStats(card);
            System.out.println(player.getScore());
            String message = player.getName() + ", do you want to take one more card?";

            while ((UserInput.getChoice(message)) && ((player.getScore()) < 21)) {
                card = deck.pop();
                player.addCard(card);
                CardManager.printCardStats(card);

                System.out.println(player.getName() + " score - " + player.getScore());
                if (player.getScore() > 21) {
                    System.out.println(player.getName() + ":you lose");
                }
            }
        }
        GameManager.printResults(players, BotPlayer.getBotResult(deck));
    }
}


