package blanc08.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void createStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        statement.close();

        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customers(id, name, email)
                VALUES('Bagus', 'Bagus', 'bagus@testmcom')
                """;

        int updated = statement.executeUpdate(sql);
        System.out.println("updated" + updated);

        statement.close();

        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM customers";

        ResultSet resultSet = statement.executeQuery(sql);
//        System.out.println("result set -> " + resultSet.getRow());

        resultSet.close();
        statement.close();
        connection.close();
    }
}

