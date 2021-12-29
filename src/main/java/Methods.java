import java.util.*;

public class Methods {


    public static List<String> shuffleStrings(List<String> source) {
        List<String> temp = new ArrayList<>(source);
        Collections.shuffle(temp);
        return temp;
    }

    public static HashMap<String, Integer> getAllCards() {
        HashMap<String, Integer> stackCards = new HashMap<>();

        stackCards.put("aceDiamonds", 11);
        stackCards.put("aceClubs", 11);
        stackCards.put("aceHurts", 11);
        stackCards.put("aceSpades", 11);
        stackCards.put("kingDiamonds", 10);
        stackCards.put("kingClubs", 10);
        stackCards.put("kingHearts", 10);
        stackCards.put("kingSpades", 10);
        stackCards.put("queenDiamonds", 10);
        stackCards.put("queenClubs", 10);
        stackCards.put("queenHearts", 10);
        stackCards.put("queenSpades", 10);
        stackCards.put("jackDiamonds", 10);
        stackCards.put("jackHearts", 10);
        stackCards.put("jackClubs", 10);
        stackCards.put("jackSpades", 10);
        stackCards.put("10Diamonds", 10);
        stackCards.put("10Clubs", 10);
        stackCards.put("10Spades", 10);
        stackCards.put("10Hearts", 10);
        stackCards.put("9Diamonds", 9);
        stackCards.put("9Clubs", 9);
        stackCards.put("9Hearts", 9);
        stackCards.put("9Spades", 9);
        stackCards.put("8Diamonds", 8);
        stackCards.put("8Spades", 8);
        stackCards.put("8Hearts", 8);
        stackCards.put("8Clubs", 8);
        stackCards.put("7Clubs", 7);
        stackCards.put("7Diamonds", 7);
        stackCards.put("7Hearts", 7);
        stackCards.put("7Spades", 7);
        stackCards.put("6Spades", 6);
        stackCards.put("6Clubs", 6);
        stackCards.put("6Diamonds", 6);
        stackCards.put("6Hearts", 6);
        stackCards.put("5Hearts", 5);
        stackCards.put("5Clubs", 5);
        stackCards.put("5Spades", 5);
        stackCards.put("5Diamonds", 5);
        stackCards.put("4Diamonds", 4);
        stackCards.put("4Spades", 4);
        stackCards.put("4Hearts", 4);
        stackCards.put("4Clubs", 4);
        stackCards.put("3Clubs", 3);
        stackCards.put("3Diamonds", 3);
        stackCards.put("3Hearts", 3);
        stackCards.put("3Spades", 3);
        stackCards.put("2Spades", 2);
        stackCards.put("2Hearts", 2);
        stackCards.put("2Diamonds", 2);
        stackCards.put("2Clubs", 2);

        return stackCards;
    }

    public static Stack<String> getDeck(HashMap<String, Integer> stackCards) {
        Stack<String> deck = new Stack<>();
        deck.addAll(Methods.shuffleStrings(new ArrayList<>(stackCards.keySet())));
        return deck;
    }

    public static int takeCard(Stack<String> deck, HashMap<String, Integer> stackCards, String userName) {
        String currentCard = deck.pop();
        int cardValue = stackCards.get(currentCard);
        System.out.println(userName + ": " + currentCard + " - " + cardValue);
        return cardValue;
    }

    public static String getResult(Integer botScore, Integer playerScore) {
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
