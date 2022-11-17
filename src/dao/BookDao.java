package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDao {

    private BookDao() throws  SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=jdbc", "postgres", "tina");
    }



}
