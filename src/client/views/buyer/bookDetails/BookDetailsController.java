package client.views.buyer.bookDetails;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import server.database.book.BookDAOImpl;
import server.database.book.BookForSaleDAO;
import server.database.book.BookForSaleDAOImpl;
import shared.Book;
import shared.BookForSale;

import java.sql.SQLException;


public class BookDetailsController {

    private BookDetailsViewModel bookDetailsViewModel;
    @FXML
    public Label numberOfItemsLabel;
    @FXML
    public Button addToCartButton;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;
    @FXML
    public Label labelAuthor;
    @FXML
    public Label labelCoverType;
    @FXML
    private Label labelTitle;
    @FXML
    public Label labelISBN;
    @FXML
    public Label labelPrice;
    @FXML
    public Label labelGenres;
    @FXML
    public Label labelSoldBy;
    @FXML
    public Label labelCondition;
    @FXML
    public Label labelPubliYear;

    public void init(BookDetailsViewModel bookDetailsViewModel) {
        labelUsername.textProperty().bindBidirectional(bookDetailsViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(bookDetailsViewModel.getFullNameProperty());
        labelTitle.textProperty().bindBidirectional(bookDetailsViewModel.titleProperty());
        labelISBN.textProperty().bindBidirectional(bookDetailsViewModel.isbnProperty());
        labelCoverType.textProperty().bindBidirectional(bookDetailsViewModel.coverTypeProperty());
        labelGenres.textProperty().bindBidirectional(bookDetailsViewModel.genreProperty());
        labelPrice.textProperty().bindBidirectional(bookDetailsViewModel.priceProperty());
        labelSoldBy.textProperty().bindBidirectional(bookDetailsViewModel.soldByProperty());
        labelCondition.textProperty().bindBidirectional(bookDetailsViewModel.conditionProperty());
        labelAuthor.textProperty().bindBidirectional(bookDetailsViewModel.authorProperty());
        labelPubliYear.textProperty().bindBidirectional(bookDetailsViewModel.yearOfPublicationProperty());
        numberOfItemsLabel.textProperty().bindBidirectional(bookDetailsViewModel.getNumberOfItemsProperty());
        bookDetailsViewModel.setNumberOfItems();
        bookDetailsViewModel.setBook(ViewHandler.getInstance().getMainPageController().getSelectedBook());
        bookDetailsViewModel.loadInitialData();
        this.bookDetailsViewModel = bookDetailsViewModel;
        bookDetailsViewModel.updateLabels();

    }

    public void onBackButton() {
        if (ViewHandler.getInstance() != null) {
            ViewHandler.getInstance().openMainViewBuyers();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No");
            alert.show();
        }


    }

    public void onAddToShoppingCart(ActionEvent actionEvent)
    {
        try {
            bookDetailsViewModel.addToShoppingCart();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("This item is already in your cart.");
            alert.show();
        }
        addToCartButton.setDisable(true);

    }
}
