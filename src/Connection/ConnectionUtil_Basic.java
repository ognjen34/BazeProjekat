package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil_Basic {
    private static Connection instance = null;

    public static Connection getConnection() throws SQLException, SQLException {
        if (instance == null || instance.isClosed()) {
            // Register JDBC driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            // Open a connection using DriverManager class
            instance = DriverManager.getConnection(ConnectionParams.LOCAL_CONNECTION_STRING,
                    ConnectionParams.USERNAME, ConnectionParams.PASSWORD);
        }

        return instance;
    }
}
