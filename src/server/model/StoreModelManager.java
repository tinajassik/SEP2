package server.model;

import shared.Book;
import shared.BookForSale;
import shared.Genre;
import shared.User;
import util.Subject;

import java.util.ArrayList;
import java.util.List;

public interface StoreModelManager extends Subject {
    BookForSale addBookForSale(String condition, double price, Book book, User user);
    void AddBook(Book book);

    List<BookForSale> getBooks();
    List<BookForSale> getBooksByTile(String title);
    ArrayList<Genre> getAllGenres();
    List<BookForSale> getBooksByGenre(String genre);
    List<BookForSale> getBookByAuthor(String authorFName, String authorLName);

}
