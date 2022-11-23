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
        model.addPropertyChangeListener("Labels", evt -> updateLabels(evt));
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void updateLabels(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            username.set(model.getUser(username.toString()).getUsername());
            fullName.set(model.getUser(fullName.toString()).getFullName());
        });
//        System.out.println(model.getUser(username.toString()).getUsername());
    }


}
