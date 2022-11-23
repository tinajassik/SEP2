package client.views.seller.addBooksView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddBooksController {

    private AddBooksViewModel addBooksViewModel;

    @FXML
    public ComboBox comboBoxAuthors;

    @FXML
    public TextField condition;

    @FXML
    public TextField coverType;

    @FXML
    public TextField isbn;

    @FXML
    public TextField genre;

    @FXML
    public TextField price;

    @FXML
    public TextField yearOfPublication;

    @FXML
    public Button addBookButton;

    public  void init(AddBooksViewModel addBooksViewModel)
    {
        this.addBooksViewModel = addBooksViewModel;
        this.condition.textProperty().bindBidirectional(addBooksViewModel.conditionProperty());
//        this.Author.textProperty().bindBidirectional(addBooksViewModel.authorProperty());
        this.isbn.textProperty().bindBidirectional(addBooksViewModel.isbnProperty());
        this.price.textProperty().bindBidirectional(addBooksViewModel.priceProperty());
        this.coverType.textProperty().bindBidirectional(addBooksViewModel.coverTypeProperty());
        this.genre.textProperty().bindBidirectional(addBooksViewModel.genreProperty());
        this.yearOfPublication.textProperty().bindBidirectional(addBooksViewModel.yearOfPublicationProperty());
    }

    @FXML

    public void addBook(ActionEvent event) {

    }


}
