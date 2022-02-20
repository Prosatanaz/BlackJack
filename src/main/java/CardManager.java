import java.util.*;

public class CardManager {

    public static Stack<Card> generateDeck(){
        Stack<Card> deck = new Stack<>();
        fillDeckBySuit(deck, "Diamonds");
        fillDeckBySuit(deck, "Clubs");
        fillDeckBySuit(deck, "Hurts");
        fillDeckBySuit(deck, "Spades");
        Collections.shuffle(deck);
        return deck;
    }

    private static void fillDeckBySuit(Stack<Card> deck, String suit){
        deck.add(new Card(suit, "Ace", 11));
        deck.add(new Card(suit, "King", 10));
        deck.add(new Card(suit, "Queen", 10));
        deck.add(new Card(suit, "Jack", 10));
        deck.add(new Card(suit, "Ten", 10));
        deck.add(new Card(suit, "Nine", 9));
        deck.add(new Card(suit, "Eight", 8));
        deck.add(new Card(suit, "Seven", 7));
        deck.add(new Card(suit, "Six", 6));
        deck.add(new Card(suit, "Five", 5));
        deck.add(new Card(suit, "Four", 4));
        deck.add(new Card(suit, "Three", 3));
        deck.add(new Card(suit, "Two", 2));
    }
}
