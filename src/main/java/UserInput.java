import java.io.Console;
import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.nextLine();
    }

    public static int getInt(String message) {
        int input = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            isInputCorrect = true;
            System.out.println(message);
            String inputStr = scanner.nextLine();
            try {
                input = Integer.parseInt(inputStr);
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
                isInputCorrect = false;
            }
        }
        return input;
    }

    public static int getIntInRange(String message, int minValue, int maxValue) {
        int input = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            input = getInt(message);
            if (input >= minValue && input <= maxValue) {
                isInputCorrect = true;
            }
        }
        return input;
    }
}
