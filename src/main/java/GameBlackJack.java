import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class GameBlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> stackCards = Methods.getAllCards();

        System.out.println("to start game, write in console yes");

        Stack<String> deck = Methods.getDeck(stackCards);
        Integer playerScore = 0;

        String userChoice = scanner.nextLine();
        while (userChoice.equals("yes")) {
            playerScore += Methods.takeCard(deck, stackCards, "Player");

            if (playerScore >= 21) {
                break;
            }

            System.out.println(playerScore);
            System.out.println("you want to take more?");
            userChoice = scanner.nextLine();
        }

        Integer botScore = 0;

        int drawnCards = 0;
        while ((drawnCards < 2) || (botScore < 16)) {
            botScore += Methods.takeCard(deck, stackCards, "Bot");
            System.out.println(botScore);
            drawnCards++;
        }

        String resultOfGame = Methods.getResult(botScore, playerScore);
        System.out.println(resultOfGame);
    }
}


