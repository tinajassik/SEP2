package client.views.buyer.checkOutView;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.BookForSale;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class CheckOutViewModel {

    private final BuyerModelManager buyerModelManager;
    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;
    private List<BookForSale> booksToBeSold;
    private StringProperty price;

    public CheckOutViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        price = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        //model.addPropertyChangeListener("Labels", evt -> updateLabels(evt));
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

//    public void updateLabels(PropertyChangeEvent evt) {
//        Platform.runLater(() -> {
//            username.set(model.getUser().getUsername());
//            fullName.set(model.getUser().getUsername());
//        });
//    }

    public ArrayList<BookForSale> getBooksFromShoppingCart() {
        return buyerModelManager.getShoppingCart();
    }

    public List<BookForSale> getBooksToBeSoldProperty() {
        return booksToBeSold;
    }

    public void purchase() {
        buyerModelManager.purchase();
    }
}
