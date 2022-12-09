package client.views.buyer.checkOutView;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import shared.BookForSale;
import shared.Buyer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class CheckOutViewModel {

    private final BuyerModelManager buyerModelManager;
    private final UserModelManager userModelManager;
    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;
    private ObservableList<BookForSale> booksToBeSold;
    private StringProperty price;

    public CheckOutViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        price = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        userModelManager = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager.addPropertyChangeListener("BookForSaleDeleted", this::onBookPurchased);
    }

    private void onBookPurchased(PropertyChangeEvent evt) {
        Platform.runLater(() -> booksToBeSold.remove((BookForSale) evt.getNewValue()));
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

//
//    public ArrayList<BookForSale> getBooksFromShoppingCart() {
//        return buyerModelManager.getShoppingCart();
//    }

//    public List<BookForSale> getBooksToBeSoldProperty() {
//        return booksToBeSold;
//    }

    public ObservableList<BookForSale> getShoppingCart() {
        return booksToBeSold;
    }

    public void loadShoppingCart() {
        List<BookForSale> booksForSaleList = buyerModelManager.getShoppingCart();
        booksToBeSold = FXCollections.observableArrayList(booksForSaleList);
    }

    public void purchase() throws Exception
    {
            buyerModelManager.purchase();
    }

    public void checkBooks() throws Exception
    {
        buyerModelManager.checkBooks();
    }

}
