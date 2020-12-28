import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        InsertComand insertComand;
        SelectComand selectComand;
        ScanKeyboard scanKeyboard = new ScanKeyboard();
        Optional<String> symbolFromKeyboard;
        boolean exitFlag = true;
        String tableName = "students";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            Statement statement = connection.createStatement();
            insertComand = new InsertComand(statement);
            selectComand = new SelectComand(statement);

            while (exitFlag) {
                showMenu();
                symbolFromKeyboard = Optional.ofNullable(scanKeyboard.inputLetter("Input letter"));

                if (symbolFromKeyboard.isPresent()) {
                    switch (symbolFromKeyboard.get()) {

                        case "1":
                            System.out.println("1 is inputed");
                            insertComand.comandInsert("CREATE TABLE " + tableName + " (" +
                                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                                    "name VARCHAR(100), " +
                                    "lastName VARCHAR(100), " +
                                    "age INTEGER, " +
                                    "groupNumber VARCHAR(100));");
                            System.out.println("Table id created");
                            break;
                        case "2":
                            System.out.println("2 is inputed");
                            insertComand.comandInsert("INSERT INTO " + tableName + "(name, lastName,age, groupNumber)" +
                                    " VALUES(" +
                                    " '" + scanKeyboard.inputLetter("Input name") + "', " +
                                    " '" + scanKeyboard.inputLetter("Input lastName") + "', " +
                                    " '" + scanKeyboard.inputLetter("Input age") + "', " +
                                    " '" + scanKeyboard.inputLetter("Input groupNumber") + "');");
                            System.out.println("Student is added");
                            break;
                        case "3":
                            System.out.println("3 is inputed");
                            insertComand.comandInsert("DELETE FROM " + tableName +
                                    " WHERE name = '" + scanKeyboard.inputLetter("Input students name, which will be " +
                                    "deleted?") +
                                    "';");
                            System.out.println("Student is deleted");
                            break;
                        case "4":
                            System.out.println("4 is inputed");
                            selectComand.comandSelect("SELECT * FROM " + tableName + " WHERE name =" +
                                    " '" + scanKeyboard.inputLetter("Input student name, which will be found") + "'" +
                                    "ORDER BY name ASC;");
                            break;
                        case "5":
                            System.out.println("5 is inputed");
                            selectComand.comandSelect("SELECT * FROM " + tableName + " ORDER BY name ASC;");
                            break;
                        case "0":
                            System.out.println("0 is inputed");
                            insertComand.comandInsert("DROP TABLE IF EXISTS " + tableName + ";");
                            System.out.println("Table id droped");
                            break;
                        case "q":
                            exitFlag = false;
                            break;
                        default:
                            System.out.println("Letter not found");
                            System.out.println("Repead request.");
                            break;
                    }
                } else {
                    System.out.println("Repeat input line. Any symbol is found.");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Program is finished");
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
}
