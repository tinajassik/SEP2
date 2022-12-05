package client.model;

import shared.Author;
import shared.BookForSale;
import shared.Genre;
import util.Subject;

import java.util.ArrayList;
import java.util.List;

public interface BuyerModelManager extends Subject {

    List<BookForSale> getBooks();
    List<BookForSale> searchBooksByTitle(String title);
    ArrayList<Genre> getAllGenres();
    List<BookForSale> searchBooksByGenre(String genre);
    List<BookForSale> searchBooksByAuthor(String authorFName, String authorLName);
    ArrayList<Author> getAllAuthors();
}
