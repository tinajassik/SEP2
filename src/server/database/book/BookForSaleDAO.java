package server.database.book;

import shared.Book;
import shared.BookForSale;
import shared.User;

import java.sql.SQLException;
import java.util.List;

public interface BookForSaleDAO {

    BookForSale create(String condition, double price, Book book, User user) throws SQLException;

    List<BookForSale> getBooksByTitle(String title);
    List<BookForSale> getBooksByGenre(String genre);
    List<BookForSale> getBooksByAuthor(String authorFName, String authorLName);

    List<BookForSale> getAllBooks() throws SQLException;
    List<BookForSale> getBooksSoldBy(String id) throws SQLException;

}
