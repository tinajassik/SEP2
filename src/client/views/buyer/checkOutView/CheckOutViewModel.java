package client.views.buyer.checkOutView;

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

    /*public void updateLabels(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            username.set(model.getUser().getUsername());
            fullName.set(model.getUser().getUsername());
        });
    }*/
}
