package server.model;

import shared.Book;
import shared.BookForSale;
import shared.User;
import util.Subject;

import java.util.List;

public interface StoreModelManager extends Subject {
    BookForSale addBookForSale(String condition, double price, Book book, User user);
    void AddBook(Book book);

    List<BookForSale> getBooks();
}
