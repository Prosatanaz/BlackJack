import java.util.Stack;

public class BotPlayer {
    public static int getBotResult(Stack<Card> deck){
        int score = 0;
        int drawnCards = 0;
        while ((drawnCards < 2) | (score < 16)) {
            score += deck.pop().getValue();
            System.out.println("Bot Score - " + score);
            drawnCards++;
        }
        return score;
    }
}
