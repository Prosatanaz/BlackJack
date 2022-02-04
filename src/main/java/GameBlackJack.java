import java.util.*;

public class GameBlackJack {

    public static void main(String[] args) {
        int playersNumber = UserInput.getIntInRange("how many players?", 1, 6);

        List<User> users = new ArrayList<>(playersNumber);
        for (int i = 0; (i < playersNumber) && (i <= 6); i++) {
            System.out.println("Enter player name");

            users.add(new User());
            users.get(i).setName(UserInput.getString());
            System.out.println(users.get(i).getName());
        }
        Stack<String> deck = CardManager.generateDeck();


        int playerID = 0;
        while (playerID < playersNumber) {
            String cardName = CardManager.takeCard(deck);
            users.get(playerID).setScore(CardManager.getCardValue(cardName));
            System.out.println("WANA TAKE MORE?");
            while ((UserInput.getString().equals("yes")) & ((users.get(playerID).getScore()) < 21)) {
                cardName = CardManager.takeCard(deck);
                System.out.println(users.get(playerID).getName() + " - You want to take more");
                int newScore = users.get(playerID).getScore() + CardManager.getCardValue(cardName);
                users.get(playerID).setScore(newScore);
                System.out.println(users.get(playerID).getName() + " score - " + users.get(playerID).getScore());
                if (users.get(playerID).getScore() > 21) {
                    System.out.println(users.get(playerID).getName() + ":you lose");
                }
            }
            playerID++;
        }

        Integer botScore = 0;

        int drawnCards = 0;
        while ((drawnCards < 2) | (botScore < 16)) {
            botScore += CardManager.getCardValue(CardManager.takeCard(deck));
            System.out.println("Bot Score - " + botScore);
            drawnCards++;
        }
        playerID = 0;
        while (playerID < playersNumber) {
            String resultOfGame = Methods.getResult(botScore, users.get(playerID).getScore());
            System.out.println(users.get(playerID).getName() + " - " + resultOfGame);
            playerID++;
        }
    }






}


