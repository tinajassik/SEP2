package server.database.book;

import shared.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GenreDAO {

    Genre create(String genreName) throws SQLException;
    ArrayList<Genre> getAllGenres() throws SQLException;
}
