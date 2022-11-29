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
    return ModelFactory.getInstance().getUserModelManager().getUser(username.toString());
  }
  public boolean validatePassword() {
    return ModelFactory.getInstance().getUserModelManager().validatePassword(username.toString(),password.toString());
  }

  public boolean userExists() {
    return ModelFactory.getInstance().getUserModelManager().validateUser(username.toString());
  }

}
