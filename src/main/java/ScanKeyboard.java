import java.util.Scanner;

public class ScanKeyboard {
    Scanner scanner;

    public ScanKeyboard() {
        scanner = new Scanner(System.in);
    }

    String inputLetter(String message) {
        System.out.println(message);
        String letter;
        do {
            letter = scanner.nextLine();
            if (letter == null) {
                System.out.println("Letter not find. Repeat you request.");
            }
        } while (letter == null);

        letter = letter.trim();
        return letter;
    }
}
