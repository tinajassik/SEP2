package client.views.shared.signView;

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
}
