package server.database.book;

import shared.Author;
import shared.Book;
import shared.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface BookDAO {

    Book create(String isbn, String title, String coverType, Author author, int YearOfPublish, ArrayList<Genre> genres) throws SQLException;
    Book readByISBN(String isbn) throws SQLException;
    List<Book> getAllBooks() throws SQLException;
    List<Book> readByTitle(String searchString) throws SQLException;
    List<Book> readByGenre(String genre) throws SQLException;
    List<Book> readByAuthor (Author author) throws SQLException;
    void update(Book book) throws SQLException;
    void delete(Book book) throws SQLException;

}
