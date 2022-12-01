package client.model;

import client.core.ClientFactory;
import client.network.Client;
import client.network.RMIClientImpl;
import shared.Author;
import shared.Book;
import shared.Genre;
import shared.User;

import java.util.ArrayList;

public class SellerModelManagerImpl implements SellerModelManager {

   private Client client;
   private Book bookGeneric;
   private Book bookToBeSold;
    public SellerModelManagerImpl() {
        client = ClientFactory.getInstance().getClient();
    }

    @Override
    public void addBookForSale(double price, String condition) {
        User soldBy = client.getUser();
        client.addBookForSale(condition, price, bookGeneric, soldBy);
    }

    @Override
    public void AddBook(String title, String isbn, String coverType, int publicationYear, Author author, ArrayList<Genre> genres) {
        bookGeneric = new Book(isbn, title, publicationYear,coverType,author,genres);
        System.out.println("Seller Model Manager");
        client.AddBook(bookGeneric);
    }

    @Override
    public ArrayList<Author> getAuthors() {
        return client.getAuthors();
    }

    @Override
    public ArrayList<Genre> getGenres() {
        return client.getGenres();
    }
}