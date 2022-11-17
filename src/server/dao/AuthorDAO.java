package server.dao;

import shared.Author;

import java.sql.SQLException;

public interface AuthorDAO {

    Author create(String firstName, String lastName) throws SQLException;
}
