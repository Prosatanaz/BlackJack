import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GameManager {

    public static void printResults(Map<Player, GameResult> results) {
        for (Player player : results.keySet()) {
            switch (results.get(player)) {
                case BLACK_JACK -> System.out.println("J");
                case WIN -> System.out.println("W");
                case DRAW -> System.out.println("D");
                case LOSE -> System.out.println("L");
            }
        }
    }

    public static void getResultsOfBets(Map<Player, GameResult> results, Map<Player, Integer> bets) {
        for (Player player : results.keySet()) {
            switch (results.get(player)) {
                case BLACK_JACK -> player.addBlackJackBet(bets.get(player));
                case WIN -> player.addBet(bets.get(player));
                case DRAW -> player.addWinBet(bets.get(player));
                case LOSE -> player.getBalance();
            }
        }
    }

    public static Map<Player, GameResult> getResults(List<Player> players, Integer botScore) {
        Map<Player, GameResult> results = new HashMap<>();
        for (Player player : players) {
            results.put(player, getResultForPlayer(player.getScore(), botScore));
        }
        return results;
    }

    public static void playGame(List<Player> players, Stack<Card> deck) {
        BotPlayer.getBotFirstCard(deck);
        for (Player player : players) {
            Card firstCard = CardManager.takeCardToUser(deck, player);
            Card secondCard = CardManager.takeCardToUser(deck, player);
            if (firstCard.getName().equals(secondCard.getName())) {
                if (UserInput.getChoice("Do you want to split game?"))

                    splitGame(player, deck, firstCard, secondCard);
            }
            serializeGame(player, deck);

        }
    }

    public static Map<Player, Integer> placeBets(List<Player> players) {
        String message = "how much do you want to bet?";
        Map<Player, Integer> bets = new HashMap<>();
        for (Player player : players) {
            int playerBet = UserInput.getIntInRange(message, 1, player.getBalance());
            bets.put(player, playerBet);
            player.placeBet(playerBet);
        }
        return bets;
    }

    private static void serializeGame(Player player, Stack<Card> deck) {
        String message = player.getName() + ", do you want to take one more card?";

        while ((UserInput.getChoice(message)) && ((player.getScore()) < 21)) {
            CardManager.takeCardToUser(deck, player);
            System.out.println(player.getName() + " score - " + player.getScore());
            if (player.getScore() > 21) {
                System.out.println(player.getName() + ":you lose");
            }

        }
    }

    private static void splitGame(Player player, Stack<Card> deck, Card firstCard, Card secondCard) {
            player.setSplitScore(firstCard.getValue());
        serializeGame(player, deck);
        player.setSplitScore(secondCard.getValue());
        serializeGame(player, deck);


    }


    private static GameResult getResultForPlayer(Integer playerScore, Integer botScore) {
        //TODO: Fix
        if (playerScore == 21) {

            return GameResult.BLACK_JACK;
        }

        if (playerScore > 21) {
            return GameResult.LOSE;
        }

        if (botScore > 21) {
            return GameResult.WIN;
        }

        if (playerScore > botScore) {
            return GameResult.WIN;
        }

        if (playerScore < botScore) {
            return GameResult.LOSE;
        }

        return GameResult.DRAW;
    }
}



