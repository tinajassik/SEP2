package client.shared.view.signView;

import client.shared.core.ViewHandler;
import client.shared.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignViewController
{

  @FXML
  private TextField usernameField;
  @FXML
  private TextField passwordField;
  private ViewHandler viewHandler;
  private SignViewModel signViewModel;

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.signViewModel = signViewModel;
    this.usernameField.textProperty().bindBidirectional(signViewModel.usernameProperty());
    this.passwordField.textProperty().bindBidirectional(signViewModel.passwordProperty());
  }

  public void onSignUp(ActionEvent actionEvent)
  {
    ViewHandler.getInstance().openCreateAccount();
  }

  public void onLogIn(ActionEvent actionEvent)
  {
  }
}
