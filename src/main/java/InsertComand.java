import java.sql.SQLException;
import java.sql.Statement;

public class InsertComand {

    private Statement statement;

    public InsertComand(Statement statement) {
        this.statement = statement;
    }

    void comandInsert(String comandLine) throws SQLException {
        System.out.println(comandLine);
        statement.executeUpdate(comandLine);
    }
}
