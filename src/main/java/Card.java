import java.util.ArrayList;
import java.util.List;

public class Card {

    public String suit;

    public int value;

     Card() {
        suit = " ";
        value = 0;

    }

    public String getValueName() {

        String name = "   ";

        if (this.value == 1) {
            name = "Ace";
        }
        else if (this.value == 2) {
            name = "Two";
        }
        else if (this.value == 3) {
            name = "Three";
        }
        else if (this.value == 4) {
            name = "Four";
        }
        else if (this.value == 5) {
            name = "Five";
        }
        else if (this.value == 6) {
            name = "Six";
        }
        else if (this.value == 7) {
            name = "Seven";
        }
        else if (this.value == 8) {
            name = "Eight";
        }
        else if (this.value == 9) {

            name = "Nine";
        }
        else if (this.value == 10) {

            name = "Ten";
        }
        else if (this.value == 11) {

            name = "Jack";
        }
        else if (this.value == 12) {

            name = "Queen";
        }
        else if (this.value == 13) {

            name = "King";

        }
        return name;

    }



}
