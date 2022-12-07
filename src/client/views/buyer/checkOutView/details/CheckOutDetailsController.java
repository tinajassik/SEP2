package client.views.buyer.checkOutView.details;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Book;


public class CheckOutDetailsController {

    private Book book;

    private CheckOutDetailsViewModel bookDetailsViewModel;
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

    @FXML
    private Button backButton;


    public void init(CheckOutDetailsViewModel bookDetailsViewModel) {
        labelUsername.textProperty().bindBidirectional(bookDetailsViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(bookDetailsViewModel.getFullNameProperty());
        labelTitle.textProperty().bindBidirectional(bookDetailsViewModel.titleProperty());
        labelISBN.textProperty().bindBidirectional(bookDetailsViewModel.isbnProperty());
        //comboBoxAuthors.textProperty().bindBidirectional(bookDetailsViewModel.authorProperty());
        //labelGenres.textProperty().bindBidirectional(bookDetailsViewModel.genreProperty());
        labelCoverType.textProperty().bindBidirectional(bookDetailsViewModel.coverTypeProperty());
        labelGenres.textProperty().bindBidirectional(bookDetailsViewModel.genreProperty());
        labelPrice.textProperty().bindBidirectional(bookDetailsViewModel.priceProperty());
        labelSoldBy.textProperty().bindBidirectional(bookDetailsViewModel.soldByProperty());
        labelCondition.textProperty().bindBidirectional(bookDetailsViewModel.conditionProperty());
        labelAuthor.textProperty().bindBidirectional(bookDetailsViewModel.authorProperty());
        labelPubliYear.textProperty().bindBidirectional(bookDetailsViewModel.yearOfPublicationProperty());


        this.bookDetailsViewModel = bookDetailsViewModel;
        bookDetailsViewModel.updateLabels();


    }

    public void onBackButton() {
        if (ViewHandler.getInstance() != null) {
            ViewHandler.getInstance().openBookDetails();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have not selected any book BITCH:(");
            alert.show();
        }


    }
}