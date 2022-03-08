import java.util.Stack;

public class BotPlayer {
    public static int getBotResult(Stack<Card> deck, int userScore) {
        int score = getBotFirstCard(deck);
        int drawnCards = 0;
        while ((score < 16) || score <= userScore ) {
            Card botCard = deck.pop();
            CardManager.printCardStats(botCard);
            score += botCard.getValue();
            System.out.println("Bot Score - " + score);
            drawnCards++;
        }
        return score;
    }

    public static int getBotFirstCard(Stack<Card> deck) {
        Card botFirstCard = deck.pop();
        System.out.println("Bot card is - ");
        CardManager.printCardStats(botFirstCard);
        return botFirstCard.getValue();

    }


}
