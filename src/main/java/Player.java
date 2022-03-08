import java.util.LinkedList;
import java.util.List;

public class Player {
    private final String name;
    private int score;
    private int balance;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.balance = 1000;
        this.cards = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getBalance() {
        return balance;
    }

    public void placeBet(int bet) {
        this.balance -= bet;
    }

    public void addBet(int bet) {
        this.balance += bet;
    }
    public void addBlackJackBet (int bet){
        this.balance += bet * 2.5f;
    }
    public  void addWinBet (int bet){
        this.balance += bet * 2;
    }

    public List<Card> getCards() {
        return cards;
    }


    public void resetForNewGame() {
        score = 0;
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
        score += card.getValue();

        System.out.println(score);
    }


    public void setSplitScore(int score){
        this.score = score;
    }
}
