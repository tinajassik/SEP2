package client.views.buyer.shoppingCartView;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.BookForSale;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ShoppingCartViewModel {

    private StringProperty fullName, username, price;
    private UserModelManager model;
    private BuyerModelManager buyerModelManager;

    ObservableList<BookForSale> shoppingCart; // observable to be loaded in the controller (with the "is book already sold" check)
    List<BookForSale>  shoppingCartList; // regular list to get all books from the cart

    public ShoppingCartViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        price = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        updateLabels();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        shoppingCartList = buyerModelManager.getShoppingCart();
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getPriceProperty() {
        return price;
    }

    public ArrayList<BookForSale> getShoppingCart()
    {
        return buyerModelManager.getShoppingCart();
    }

    public void removeFromShoppingCart(BookForSale bookForSale)
    {
        buyerModelManager.removeFromShoppingCart(bookForSale);
    }

    public ArrayList<BookForSale> getAvailableBooks() {
       return (ArrayList<BookForSale>) buyerModelManager.getBooks();
    }


    public List<BookForSale> getShoppingCartList() {
        return shoppingCartList;
    }

    public ObservableList<BookForSale> getShoppingCartObservableList() {
        return shoppingCart;
    }



    public void loadBooksForSale() {
        // loading cart with each opening - works !
        List<BookForSale> booksFromShoppingCart = buyerModelManager.getShoppingCart();
        List<BookForSale> availableBooks = buyerModelManager.getBooks();

        try {
            for (BookForSale book: booksFromShoppingCart) {
                if (!availableBooks.contains(book)) {
                    shoppingCartList.remove(book);
                }
        }}
            catch(ConcurrentModificationException e) {
                System.out.println("There is an exception but it does not affect the functionality I think");
            }

        shoppingCart = FXCollections.observableArrayList(shoppingCartList);
    }



    public void setPrice()
    {
        price.set(Double.toString(buyerModelManager.calculatePrice()));
    }



    public void updateLabels()
    {
        username.set(model.getUser().getUsername());
        fullName.set(model.getUser().getFullName());
    }
}
