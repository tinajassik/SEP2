package server.database.book;

import server.database.DatabaseConnection;
import shared.Author;
import shared.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Genre> getAllGenres() throws SQLException {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from genre;");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Genre> allGenres = new ArrayList<>();
            while (resultSet.next()) {
                allGenres.add(new Genre(resultSet.getString(1)));
            }
            return allGenres;
        }
    }
}
