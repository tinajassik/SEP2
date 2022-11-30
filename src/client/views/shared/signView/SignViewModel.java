package client.views.shared.signView;

import client.core.ModelFactory;
import shared.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SignViewModel
{
  private StringProperty username, password;

  public SignViewModel()
  {
    this.username = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
  }

  public StringProperty usernameProperty(){return username;}
  public StringProperty passwordProperty(){return password;}

  public User getUserType() {
    return ModelFactory.getInstance().getUserModelManager().getUser(username.getValue());
  }
  public boolean validatePassword() throws IllegalAccessException {
    return ModelFactory.getInstance().getUserModelManager().validatePassword(username.getValue(),password.getValue());
  }

  public boolean userExists() throws IllegalAccessException {
    return ModelFactory.getInstance().getUserModelManager().validateUser(username.getValue());
  }

}
