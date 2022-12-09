package client.model;

import client.core.ClientFactory;
import client.network.Client;
import shared.*;

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
        client.addPropertyChangeListener("BookForSaleDeleted", this::onBookForSaleDeleted);
        shoppingCart = new ArrayList<>();
    }

    private void onNewBookForSale(PropertyChangeEvent evt) {
//        System.out.println(evt.getNewValue().toString());
        System.out.println("new book for sale in buyer model manager");
        support.firePropertyChange(evt);
    }

    private void onBookForSaleDeleted(PropertyChangeEvent evt) {
        System.out.println("book deleted in buyer model manager");
        support.firePropertyChange(evt);
    }


    //get Available books
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
        System.out.println(bookForSale);
        support.firePropertyChange("New number of items",null, null);

    }

    @Override public void removeFromShoppingCart(BookForSale bookForSale)
    {
        shoppingCart.remove(bookForSale);
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
    // also works
    public void purchase() throws Exception
    {
        List<BookForSale> availableBooks = getBooks();
        for (BookForSale book: shoppingCart)
        {
            if (!availableBooks.contains(book)) {
                shoppingCart.remove(book);
                throw new Exception();
            }
        }

//        THIS Was throwing an error I think
//        for (BookForSale book: shoppingCart) {
//            client.createOrder(new Order((Buyer) client.getUser(), (Seller) book.getUser(), book));
//        }

        client.purchase(shoppingCart);
        shoppingCart.clear();
    }


    @Override public void createOrder(Buyer buyer)
    {
        for (BookForSale soldBook:shoppingCart)
        {
                Seller seller = (Seller) soldBook.getUser();
                Order order = new Order(buyer, seller, soldBook);
                client.createOrder(order);
        }
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
