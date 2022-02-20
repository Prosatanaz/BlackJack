import java.util.List;
import java.util.Stack;

public class GameManager {

    public static void printResults(List<Player> players, int botScore) {
        for (Player player : players) {
            String resultOfGame = GameManager.getResultForPlayer(botScore, player.getScore());
            System.out.println(player.getName() + " - " + resultOfGame);
        }
    }

    private static String getResultForPlayer(Integer botScore, Integer playerScore) {
        if (playerScore > 21) {
            return "you lose";
        }

        if (botScore > 21) {
            return "you winner";
        }

        if (playerScore > botScore) {
            return "you winner";
        }

        if (playerScore < botScore) {
            return "you lose";
        }

        return "draw";
    }


}
