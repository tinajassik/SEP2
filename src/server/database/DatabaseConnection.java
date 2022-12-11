package server.database;

import org.postgresql.Driver;
import server.database.book.AuthorDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String url = "jdbc:postgresql://mouse.db.elephantsql.com:5432/jmnwgfvg";
    private String username = "jmnwgfvg";
    private String password = "TtdW1QHeNvPi3xTqaE6U1TaON3FDsL1T";
    private static DatabaseConnection instance;

    public synchronized Connection getConnection() {
        try {

            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, username,password);

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
