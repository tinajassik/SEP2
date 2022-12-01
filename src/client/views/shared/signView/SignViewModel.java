package client.views.shared.signView;

import client.core.ModelFactory;
import client.model.UserModelManager;
import shared.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SignViewModel
{
  private StringProperty username, password;
  private UserModelManager userModelManager;

  public SignViewModel()
  {
    this.username = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
    this.userModelManager = ModelFactory.getInstance().getUserModelManager();
  }

  public StringProperty usernameProperty(){return username;}
  public StringProperty passwordProperty(){return password;}

  public User getUserType() {
    return userModelManager.getUserType(username.getValue());
  }
  public boolean validatePassword() throws IllegalAccessException {
    return userModelManager.validatePassword(username.getValue(),password.getValue());
  }

  public boolean userExists() throws IllegalAccessException {
    return userModelManager.validateUser(username.getValue());
  }

}
