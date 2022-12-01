package client.views.buyer.mainPageView;

import client.core.ModelFactory;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class MainPageViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;

    public MainPageViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }


    public void updateLabels() {
            username.set(model.getUser().getUsername());
            fullName.set(model.getUser().getFullName());
    }
}
