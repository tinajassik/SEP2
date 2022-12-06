package client.model;

import shared.Author;
import shared.BookForSale;
import shared.Genre;

import java.util.ArrayList;
import java.util.List;

public interface SellerModelManager {

    void addBookForSale(double price, String condition);
    void AddBook(String title, String isbn, String coverType, int publicationYear, Author author, ArrayList<Genre> genres);
    ArrayList<Author> getAuthors();
    ArrayList<Genre> getGenres();
    List<BookForSale> getBooksSoldByMe(String id);

    List<BookForSale> searchBooksByTitle(String title);

}
