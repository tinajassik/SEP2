package client.model;

import client.core.ClientFactory;
import client.network.Client;
import shared.Author;
import shared.BookForSale;
import shared.Genre;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class BuyerModelManagerImpl implements BuyerModelManager {

    private Client client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ArrayList<BookForSale> shoppingCart;
    private double shoppingCartPrice;

    public BuyerModelManagerImpl() {
        client = ClientFactory.getInstance().getClient();
        client.addPropertyChangeListener("NewBookForSale", this::onNewBookForSale);
        shoppingCart = new ArrayList<>();
    }

    private void onNewBookForSale(PropertyChangeEvent evt) {
        System.out.println(evt.getNewValue().toString());
        System.out.println("observer in buyer model manager");
        support.firePropertyChange(evt);

    }

    public List<BookForSale> getBooks() {
         return client.getBooks();
    }

    @Override public List<BookForSale> searchBooksByTitle(String title)
    {
        return client.searchBooksByTitle(title);
    }

    @Override public ArrayList<Genre> getAllGenres()
    {
        return client.getAllGenres();
    }

    @Override public List<BookForSale> searchBooksByGenre(String genre)
    {
        return client.searchBooksByGenre(genre);
    }

    @Override public List<BookForSale> searchBooksByAuthor(String authorFName, String authorLName)
    {
        return client.searchBooksByAuthor(authorFName, authorLName);
    }

    @Override public ArrayList<Author> getAllAuthors()
    {
        return client.getAuthors();
    }

    @Override public void addToShoppingCart(BookForSale bookForSale)
    {
        shoppingCart.add(bookForSale);
        support.firePropertyChange("New number of items",null, null);
    }

    @Override public void removeFromShoppingCart(BookForSale bookForSale)
    {
        shoppingCart.remove(bookForSale);
        support.firePropertyChange("New number of items",null, null);

    }

    @Override public ArrayList<BookForSale> getShoppingCart()
    {
        return shoppingCart;
    }

    @Override public double calculatePrice()
    {
        double price = 0;
        for (BookForSale book: shoppingCart)
        {
            price += book.getPrice();
        }
        shoppingCartPrice = price;
        return price;
    }

    @Override public double getPrice()
    {
        return shoppingCartPrice;
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
