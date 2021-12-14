import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class GameBlackJack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> stackCards = Methods.getAllCards();

        System.out.println("to start game, write in console yes");
        String userChoise = scanner.nextLine();
        if (userChoise.equals("yes")) {
            Stack<String> deck = Methods.getDeck(stackCards);

            Integer score = 0;

            score += Methods.takeCard(deck, stackCards);
            System.out.println(score);

            userChoise = "yes";


            while (userChoise.equals("yes")) {
                score += Methods.takeCard(deck, stackCards);
                System.out.println(score);


                if (score > 21) {
                    System.out.println("ti v govne");
                    break;
                }
                System.out.println("you want to take more?");
                userChoise = scanner.nextLine();
            }

            if (score <= 21){
                Integer botScore = 0;

                botScore += Methods.takeCard(deck, stackCards);
                System.out.println(botScore);
                botScore += Methods.takeCard(deck, stackCards);
                System.out.println(botScore);
                while (botScore <= 16) {
                    botScore += Methods.takeCard(deck, stackCards);
                    System.out.println(botScore);


                }
                if (botScore > 21) {
                    System.out.println("you winner");

                }

                if (score > botScore) {
                    System.out.println("you winner");
                }
                if (score == botScore) {
                    System.out.println("draw");

                }
                if (score < botScore & botScore<=21){
                    System.out.println("Lose");
                }
            }
        }

    }
}
