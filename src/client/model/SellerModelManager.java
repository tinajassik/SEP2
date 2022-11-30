package client.model;

import shared.Author;
import shared.Genre;

import java.util.ArrayList;

public interface SellerModelManager {

    void AddBook();
    ArrayList<Author> getAuthors();
    ArrayList<Genre> getGenres();

}
