import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectComand {

    private Statement statement;
    ResultSet cursor;

    public SelectComand(Statement statement) {
        this.statement = statement;
    }

    void comandSelect(String comandLine) throws SQLException {
        cursor = statement.executeQuery(comandLine);
        while (cursor.next()) {
            //вывод данных из таблицы
            System.out.println(cursor.getString("name"));
        }
    }
}
