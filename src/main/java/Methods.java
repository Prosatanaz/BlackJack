import java.util.*;

public class Methods {

    public static List<String> shuffleStrings(List<String> source) {
        List<String> temp = new ArrayList<>(source);
        Collections.shuffle(temp);
        return temp;
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
