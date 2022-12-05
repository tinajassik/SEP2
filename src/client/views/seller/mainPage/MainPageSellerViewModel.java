package client.views.seller.mainPage;

import client.core.ModelFactory;
import client.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainPageSellerViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager userModelManager;

    public MainPageSellerViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        userModelManager = ModelFactory.getInstance().getUserModelManager();
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void updateLabels()
    {
        username.set(userModelManager.getUser().getUsername());
        fullName.set(userModelManager.getUser().getFullName());
    }
}
