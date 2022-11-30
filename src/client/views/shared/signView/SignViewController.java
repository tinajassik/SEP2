package client.views.shared.signView;

import client.core.ViewHandler;
import shared.Buyer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class SignViewController
{

  @FXML
  private TextField usernameField;
  @FXML
  private TextField passwordField;
  private ViewHandler viewHandler;
  private SignViewModel signViewModel;

  public void init(ViewHandler viewHandler, SignViewModel signViewModel)
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
    // checking if the user has an account and the password is correct
//    if (signViewModel.userExists() &&
//            signViewModel.validatePassword()) {
//      // checking if the user is a buyer or a seller
      if (signViewModel.getUserType() instanceof Buyer)
      {
        viewHandler.openMainViewBuyers();
      }
      else
       viewHandler.openMainViewSellers();
    }
//    else {
//      Alert alert = new Alert(Alert.AlertType.ERROR);
//      alert.setContentText("Account does not exist/Incorrect password. Try again!");
//      alert.show();
//    }

  }


