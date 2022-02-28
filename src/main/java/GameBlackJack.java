import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GameBlackJack {

    public static void main(String[] args) {
        int playersCount = UserInput.getIntInRange("how many players?", 1, 6);

        List<Player> players = new ArrayList<>(playersCount);

        for (int i = 0; i < playersCount; i++) {
            System.out.println("Enter player name");
            players.add(new Player(UserInput.getString()));
        }

        while (true) {
            Map<Player, Integer> bets = GameManager.placeBets(players);
            Stack<Card> deck = CardManager.generateDeck();
            GameManager.playGame(players, deck);

            Map<Player, GameResult> gameResults = GameManager.getResults(players, BotPlayer.getBotResult(deck));
            GameManager.printResults(gameResults);
            GameManager.getResultsOfBets(gameResults, bets);

            if (!UserInput.getChoice("do you want to play again?")) {
                break;
            }

            players.forEach(Player::resetForNewGame);
        }
    }
}


