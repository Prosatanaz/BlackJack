import java.util.*;

public class GameBlackJack {
    public static void main(String[] args) {
        HashMap<String, Integer> stackCards = Methods.getAllCards();


        int playersNumber = UserInput.getIntInRange("how many players?", 1, 6);


        List<User> users = new ArrayList<>(playersNumber);
        for (int i = 0; (i < playersNumber) && (i <= 6); i++) {
            System.out.println("Enter player name");

            users.add(new User());
            users.get(i).setName(UserInput.getString());
            System.out.println(users.get(i).getName());
        }
        Stack<String> deck = Methods.getDeck(stackCards);
        int playerID = 0;

        while (playerID < playersNumber) {
            users.get(playerID).setScore(Methods.takeCard(deck, stackCards, users.get(playerID).getName()));

            System.out.println("WANA TAKE MORE?");

            while ((UserInput.getString().equals("yes")) & ((users.get(playerID).getScore()) < 21)) {
                users.get(playerID).setScore(users.get(playerID).getScore() + Methods.takeCard(deck, stackCards, users.get(playerID).getName()));
                System.out.println(users.get(playerID).getScore());
            }
            playerID++;

        }


        Integer botScore = 0;

        int drawnCards = 0;
        while ((drawnCards < 2) | (botScore < 16)) {
            botScore += Methods.takeCard(deck, stackCards, "Bot");
            System.out.println(botScore);
            drawnCards++;
        }
        playerID = 0;
        while (playerID < playersNumber) {
            String resultOfGame = Methods.getResult(botScore, users.get(playerID).getScore());
            System.out.println(resultOfGame);
            playerID++;
        }
    }
}


