package server.database.book;

import shared.Genre;

import java.sql.SQLException;

public interface GenreDAO {

    Genre create(String genreName) throws SQLException;
}
