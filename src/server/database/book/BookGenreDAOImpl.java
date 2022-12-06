package server.database.book;

import server.database.DatabaseConnection;
import shared.BookGenre;
import shared.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookGenreDAOImpl implements BookGenreDAO {

    private static BookGenreDAOImpl instance;
    private Connection connection;

    private BookGenreDAOImpl() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public synchronized static BookGenreDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookGenreDAOImpl();
        }
        return instance;
    }

    public BookGenre create(String genreName, String isbn) {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bookgenre (genre_name, isbn) values (?,?);");
            preparedStatement.setString(1,genreName);
            preparedStatement.setString(2,isbn);
            preparedStatement.executeUpdate();
            return new BookGenre(genreName, isbn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Genre> getGenresForBook(String isbn) {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT genre_name from bookgenre where isbn = ?");
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Genre> genres = new ArrayList<>();
            while (resultSet.next()) {
                genres.add(new Genre(resultSet.getString("genre_name")));
            }
            return genres;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String isbn, ArrayList<Genre> genres) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bookgenre SET genre_name = ? where isbn = ?");

            if (genres.size() == getGenresForBook(isbn).size()) {
                for (Genre g: genres
                ) {
                    preparedStatement.setString(1, g.getGenreName());
                    preparedStatement.setString(2, isbn);
                    preparedStatement.executeUpdate();
                }
            } else {
                delete(isbn);
                for (Genre g: genres) {
                    create(g.getGenreName(), isbn);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String isbn) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM bookgenre WHERE isbn = ?");
            statement.setString(1, isbn);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }









}
