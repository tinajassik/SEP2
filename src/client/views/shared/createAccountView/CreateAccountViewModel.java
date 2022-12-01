package client.views.shared.createAccountView;

import client.core.ModelFactory;
import client.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateAccountViewModel implements Subject
{
  private StringProperty fullName, dateOfBirth, address, phoneNumber, email, username, password;
  private UserModelManager userModelManager;
  private PropertyChangeSupport propertyChangeSupport;

  public CreateAccountViewModel()
  {
    this.fullName = new SimpleStringProperty();
    this.dateOfBirth = new SimpleStringProperty();
    this.address = new SimpleStringProperty();
    this.phoneNumber = new SimpleStringProperty();
    this.email = new SimpleStringProperty();
    this.username = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
    this.userModelManager = ModelFactory.getInstance().getUserModelManager();
    this.propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public StringProperty fullNameProperty()
  {
    return fullName;
  }

  public StringProperty dateOfBirthProperty()
  {
    return dateOfBirth;
  }

  public StringProperty addressProperty()
  {
    return address;
  }

  public StringProperty phoneNumberProperty()
  {
    return phoneNumber;
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public boolean registerBuyer() {

        return userModelManager.registerBuyer(fullName.getValue(), address.getValue(),
            phoneNumber.getValue(), email.getValue(), username.getValue(),
            password.getValue());

  //      propertyChangeSupport.firePropertyChange("Seller registered", null, null);

  }
//      Alert alert = new Alert(Alert.AlertType.ERROR);
//      alert.setContentText("Username already exists. Sorry");
//      alert.show();

//      propertyChangeSupport.firePropertyChange("Invalid username", null, null);


  public boolean registerSeller()  {
    System.out.println("in view model");
      return userModelManager.registerSeller(fullName.getValue(), address.getValue(),
              phoneNumber.getValue(), email.getValue(), username.getValue(),
              password.getValue());


  //      propertyChangeSupport.firePropertyChange("Buyer registered", null, null);
  }
////    else
//      propertyChangeSupport.firePropertyChange("Invalid username", null, null);


  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(eventName,listener);

  }
}
