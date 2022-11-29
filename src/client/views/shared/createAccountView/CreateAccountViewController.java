package client.views.shared.createAccountView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;

public class CreateAccountViewController
{
  @FXML
  private TextField fullNameField;
  @FXML
  private TextField dateOfBirthField;
  @FXML
  private TextField addressField;
  @FXML
  private TextField phoneNumberField;
  @FXML
  private TextField emailField;
  @FXML
  private TextField usernameField;
  @FXML
  private TextField passwordField;

  private CreateAccountViewModel createAccountViewModel;

  public void init(CreateAccountViewModel createAccountViewModel)
  {
    this.createAccountViewModel = createAccountViewModel;
    this.fullNameField.textProperty().bindBidirectional(createAccountViewModel.fullNameProperty());
    this.dateOfBirthField.textProperty().bindBidirectional(createAccountViewModel.dateOfBirthProperty());
    this.addressField.textProperty().bindBidirectional(createAccountViewModel.addressProperty());
    this.phoneNumberField.textProperty().bindBidirectional(createAccountViewModel.phoneNumberProperty());
    this.emailField.textProperty().bindBidirectional(createAccountViewModel.emailProperty());
    this.usernameField.textProperty().bindBidirectional(createAccountViewModel.usernameProperty());
    this.passwordField.textProperty().bindBidirectional(createAccountViewModel.passwordProperty());
    createAccountViewModel.addPropertyChangeListener("Username invalid", this::usernameError);
    createAccountViewModel.addPropertyChangeListener("Buyer registered", this::buyerRegistered);
    createAccountViewModel.addPropertyChangeListener("Seller registered", this::sellerRegistered);
  }

  public void onRegisterSeller(ActionEvent actionEvent)
  {
    createAccountViewModel.registerSeller();
  }

  public void onRegisterBuyer(ActionEvent actionEvent)
  {

    createAccountViewModel.registerBuyer();
  }

  public void buyerRegistered(PropertyChangeEvent e)
  {
    ViewHandler.getInstance().openMainViewBuyers();
  }

  public void sellerRegistered(PropertyChangeEvent e)
  {
    ViewHandler.getInstance().openMainViewSellers();
  }

  public void usernameError(PropertyChangeEvent e)
  {

  }
}
