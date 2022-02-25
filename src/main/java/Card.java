public class Card {

    private final String suit;
    private final String name;
    private final int defaultValue;
    private boolean isAceMinValue = false;

    Card(String suit, String name, int defaultValue) {
        this.suit = suit;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        if (name.equals("Ace") && isAceMinValue) {
            return 1;
        }

        return defaultValue;
    }

    public void setIsAceMinValue(boolean aceMinValue) {
        isAceMinValue = aceMinValue;
    }
}
