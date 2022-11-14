package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection createConnect() throws SQLException {
        return DriverManager
                .getConnection
                        ("jdbc:postgresql://localhost:5432/postgres",
                                "postgres",
                                "admin");
    }


}
