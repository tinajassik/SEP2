package client.views.buyer.checkOut;

import client.core.ModelFactory;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class CheckOutViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;

    private StringProperty price;

    public CheckOutViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        price = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
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

    public void updateLabels() {
            username.set(model.getUser().getUsername());
            fullName.set(model.getUser().getFullName());
    }
}
