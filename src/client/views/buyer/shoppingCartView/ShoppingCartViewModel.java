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
import java.util.List;

public class ShoppingCartViewModel {

    private StringProperty fullName, username, price;
    private UserModelManager model;
    private BuyerModelManager buyerModelManager;
    ObservableList<BookForSale> shoppingCart;

    public ShoppingCartViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        price = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        updateLabels();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
//        model.addPropertyChangeListener("Labels", evt -> updateLabels(evt));
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

    public ObservableList<BookForSale> getShoppingCartList() {
        return shoppingCart;
    }
    void loadBooksForSale() {
        List<BookForSale> booksForSaleList = buyerModelManager.getShoppingCart();
        shoppingCart = FXCollections.observableArrayList(booksForSaleList);
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
