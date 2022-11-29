package server.database.book;

import shared.Author;
import shared.Book;
import java.sql.SQLException;
import java.util.List;


public interface BookDAO {

    Book create(String isbn, String title, String genre, String condition, String coverType, Author author, int YearOfPublish, double price) throws SQLException;
    Book readByISBN(String isbn) throws SQLException;
    List<Book> getAllBooks() throws SQLException;
    List<Book> readByTitle(String searchString) throws SQLException;
    List<Book> readByGenre(String genre) throws SQLException;
    List<Book> readByAuthor (Author author) throws SQLException;
    void update(Book book) throws SQLException;
    void delete(Book book) throws SQLException;

}
