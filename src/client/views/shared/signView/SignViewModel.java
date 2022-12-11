package client.views.shared.signView;

import client.core.ModelFactory;
import client.model.AccountModelManager;
import shared.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SignViewModel
{
  private StringProperty username, password;
  private AccountModelManager accountModelManager;

  public SignViewModel()
  {
    this.username = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
    accountModelManager = ModelFactory.getInstance().getUserModelManager();
  }

  public StringProperty usernameProperty(){return username;}
  public StringProperty passwordProperty(){return password;}

  public User getUserType() {
    return accountModelManager.getUserType(username.getValue());
  }
  public boolean validatePassword() throws IllegalAccessException {
    return accountModelManager.validatePassword(username.getValue(),password.getValue());
  }

  public boolean userExists() throws IllegalAccessException {
    return accountModelManager.validateUser(username.getValue());
  }

}
