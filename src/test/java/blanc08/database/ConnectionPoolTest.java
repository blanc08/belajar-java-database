package blanc08.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);

            Connection connection = dataSource.getConnection();
            System.out.println("sukses mengambil koneksi");
            connection.close();
            System.out.println("sukses menutup koneksi");
            dataSource.close();
            System.out.println("sukses menutup seluruh datasource");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            Assertions.fail(exception);

        }
    }


    @Test
    void tesUtil() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }
}
