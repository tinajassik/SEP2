package server.model;

import shared.*;
import util.Subject;

import java.util.ArrayList;
import java.util.List;

public interface StoreModelManager extends Subject {
    BookForSale addBookForSale(String condition, double price, Book book, User user);
    void AddBook(Book book);
    List<BookForSale> getBooks();

    List<BookForSale> getBooksByTile(String title);
    ArrayList<Genre> getAllGenres();
    ArrayList<Author> getAllAuthors();
    List<BookForSale> getBooksByGenre(String genre);
    List<BookForSale> getBookByAuthor(String authorFName, String authorLName);


    List<BookForSale> getBooksSoldBy(String id);

    void editBook(String condition, double price, Book book, String username);

}
