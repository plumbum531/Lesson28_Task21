import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    void showMenu() {
        System.out.println("1 - " + "create table");
        System.out.println("2 - " + "add line");
        System.out.println("3 - " + "delete line");
        System.out.println("4 - " + "find students dy name with sort А to Я");
        System.out.println("5 - " + "find all students with sort from А to Я");
        System.out.println("0 - " + "delete table");
        System.out.println("q - " + "exit");
    }

    String inputLetter(String message) {
        System.out.println(message);
        String letter = scanner.nextLine();

        if (letter == null) {
            System.out.println("Letter not find");
            inputLetter(message);
        }
        letter = letter.trim();
        return letter;
    }
}
