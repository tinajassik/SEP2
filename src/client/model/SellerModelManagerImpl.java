package client.model;

import client.core.ClientFactory;
import client.network.Client;
import client.network.RMIClientImpl;
import shared.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class SellerModelManagerImpl implements SellerModelManager {

   private Client client;
   private Book bookGeneric;
   private PropertyChangeSupport support;

    public SellerModelManagerImpl() {
        client = ClientFactory.getInstance().getClient();
        support = new PropertyChangeSupport(this);
        client.addPropertyChangeListener("BookForSaleDeleted", this::onBookGotPurchased);
    }

    @Override
    public void addBookForSale(double price, String condition) {
        User soldBy = client.getUser();
        client.addBookForSale(condition, price, bookGeneric, soldBy);
    }


    public void onBookGotPurchased(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }



    @Override
    public void AddBook(String title, String isbn, String coverType, int publicationYear, Author author, ArrayList<Genre> genres) {
        bookGeneric = new Book(isbn, title, publicationYear,coverType,author,genres);
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

    @Override
    public List<BookForSale> getBooksSoldByMe(String id) {
       return client.getBooksSoldBy(id);
    }

    @Override
    public List<BookForSale> searchBooksByTitle(String title) {
        return client.searchBooksByTitle(title);
    }

    @Override
    public void editBook(String title, String isbn, int publicationYear, String coverType, String condition, double price, Author author, ArrayList<Genre> genres) {
        Book genericBookEdited = new Book(isbn, title,publicationYear,coverType,author,genres);
        User soldBy = client.getUser();
        client.editBook(condition,price,genericBookEdited, soldBy.getUsername());
    }

    @Override
    public void deleteBook(BookForSale bookToBeDeleted) {
        client.deleteBook(bookToBeDeleted.getId());
    }


    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
