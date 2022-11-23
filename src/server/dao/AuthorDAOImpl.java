package server.dao;

import shared.Author;

import java.sql.*;

public class AuthorDAOImpl implements AuthorDAO{

    private static AuthorDAOImpl instance;

    private AuthorDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized AuthorDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new AuthorDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=jdbc", "postgres", "mariusz4111");
    }

    @Override
    public Author create(String firstName, String lastName) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Author(firstname, lastname) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                return new Author(firstName,lastName, keys.getInt(3));
            } else {
                throw new SQLException("No keys generated");
            }
        }
    }
}
