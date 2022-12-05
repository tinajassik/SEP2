package server.database.book;

import shared.BookGenre;
import shared.Genre;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookGenreDAO {

    BookGenre create(String genreName, String isbn) throws SQLException;
    ArrayList<Genre> getGenresForBook(String isbn) throws SQLException;


}
