import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectComand {

    private final Statement statement;
    ResultSet cursor;

    public SelectComand(Statement statement) {
        this.statement = statement;
    }

    void comandSelect(String comandLine) throws SQLException {
        cursor = statement.executeQuery(comandLine);
        while (cursor.next()) {
            //вывод данных из таблицы
            System.out.print("name = " + cursor.getString("name") +", ");
            System.out.print("lastName = " + cursor.getString("lastName")+", ");
            System.out.print("age = " + cursor.getString("age")+", ");
            System.out.println("groupNumber = " + cursor.getString("groupNumber")+".");
        }
    }
}
