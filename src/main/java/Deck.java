public class Deck {
    Card[] deck = new Card[52];


    public Deck() {

        int countr = 0;

        for (int i = 1; i <= 13; i++) {
            deck[countr++] = new Card("Hearts", i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[countr++] = new Card("Spades", i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[countr++] = new Card("Clubs", i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[countr++] = new Card("Diamonds", i);
        }
    }

}
