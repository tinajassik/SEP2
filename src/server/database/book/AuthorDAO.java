package server.database.book;

import shared.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDAO {

    Author create(String firstName, String lastName) throws SQLException;
    List<Author> getAllAuthors() throws SQLException;
}
