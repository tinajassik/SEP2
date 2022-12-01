package client.model;

import shared.Author;
import shared.Genre;

import java.util.ArrayList;

public interface SellerModelManager {

    void AddBook(String title, String isbn, String coverType, int publicationYear, Author author, ArrayList<Genre> genres);
    ArrayList<Author> getAuthors();
    ArrayList<Genre> getGenres();

}
