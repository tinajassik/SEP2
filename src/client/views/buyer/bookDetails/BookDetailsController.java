package client.views.buyer.bookDetails;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class BookDetailsController {
    private BookDetailsViewModel bookDetailsViewModel;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;
    @FXML
    private Button buttonAddToShoppingCart;
    @FXML
    private Button  buttonShoppingCart;
    @FXML
    private Button backButton;


    public void init(BookDetailsViewModel bookDetailsViewModel) {
        labelUsername.textProperty().bindBidirectional(bookDetailsViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(bookDetailsViewModel.getFullNameProperty());
        this.bookDetailsViewModel = bookDetailsViewModel;
        bookDetailsViewModel.updateLabels();
    }
}
