package client.views.buyer.bookDetails;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookDetailsViewModel {
    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;
    private BuyerModelManager buyerModelManager;


    public BookDetailsViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        //buyerModelManager.addPropertyChangeListener("NewBookForSale", this::onNewBookForSale);
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void updateLabels()
    {
        username.set(model.getUser().getUsername());
        fullName.set(model.getUser().getFullName());
    }

    public void getBookDetails(int id) {

    }
}

