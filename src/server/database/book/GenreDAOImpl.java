package server.database.book;

import server.database.DatabaseConnection;
import shared.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDAOImpl implements GenreDAO{

    private static GenreDAOImpl instance;

    public synchronized static GenreDAOImpl getInstance () {
        if (instance == null) {
            instance = new GenreDAOImpl();
        }
        return instance;
    }

    public Genre create(String genreName) throws SQLException {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genre (genre_name) values (?)");
            preparedStatement.setString(1,genreName);
            preparedStatement.executeUpdate();
        }
        return new Genre(genreName);
    }
}
