package client.views.buyer.mainPageView;


import client.core.ViewHandler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import shared.Author;
import shared.BookForSale;
import shared.Genre;

import java.util.ArrayList;

public class MainPageController {


    private MainPageViewModel mainPageViewModel;
    @FXML
    public Label itemsInCartLabel;
    @FXML
    private GridPane gridPaneBooks;
    @FXML
    private ListView listViewBooks;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private ComboBox comboBoxAuthors;
    @FXML
    private ComboBox comboBoxGenres;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;
    @FXML
    private Button  buttonShoppingCart;
    @FXML
    private Button  buttonSignOut;

    public void init(MainPageViewModel mainPageViewModel) {
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
        itemsInCartLabel.textProperty().bindBidirectional(mainPageViewModel.getNumberOfItemsProperty());
        this.mainPageViewModel = mainPageViewModel;
        this.mainPageViewModel.loadBooksForSale();
        listViewBooks.setItems(this.mainPageViewModel.getBooksForSale());
        mainPageViewModel.setNumberOfItems();
        mainPageViewModel.updateLabels();
        displayGenres();
        displayAuthors();
    }
    @FXML
    public void onSignOut(ActionEvent actionEvent) {
        ViewHandler.getInstance().openSign();
    }

    @FXML
    public void onShoppingCart (ActionEvent actionEvent) {
        ViewHandler.getInstance().openShoppingCart();

    }

    @FXML
    public void onSearchByTitle (ActionEvent actionEvent) {
        listViewBooks.setItems(mainPageViewModel.searchBooksByTitle(textFieldSearch.getText()));
    }

    @FXML
    public void onSearchByGenres (ActionEvent actionEvent) {
        if (comboBoxGenres.getSelectionModel().getSelectedItem() != null)
        listViewBooks.setItems(mainPageViewModel.searchBooksByGenre(comboBoxGenres.getSelectionModel().getSelectedItem().toString()));

    }

    @FXML
    public void onSearchByAuthors (ActionEvent actionEvent) {
        if (comboBoxAuthors.getSelectionModel().getSelectedItem() != null) {
            Author chosenAuthor = mainPageViewModel.getAllAuthors().get(comboBoxAuthors.getSelectionModel().getSelectedIndex());
            String authorFName = chosenAuthor.getFname();
            String authorLName = chosenAuthor.getLname();
            listViewBooks.setItems(mainPageViewModel.searchBooksByAuthor(authorFName, authorLName));
        }
    }

    public void displayGenres()
    {
        ArrayList<Genre> genres = mainPageViewModel.getAllGenres();

        for (Genre genre:genres)
        {
            comboBoxGenres.getItems().add(genre);
        }
    }

    public void displayAuthors()
    {
        ArrayList<Author> authors = mainPageViewModel.getAllAuthors();

        for (Author author:authors)
        {
            comboBoxAuthors.getItems().add(author);
        }
    }

    public void onSeeAllBooks(ActionEvent actionEvent)
    {
        listViewBooks.setItems(this.mainPageViewModel.getBooksForSale());
    }

    public BookForSale getSelectedBook() {
        return (BookForSale) listViewBooks.getSelectionModel().getSelectedItem();
    }

    public void onSeeDetails(){
        if (listViewBooks.getSelectionModel().getSelectedItem() != null) {
            ViewHandler.getInstance().openBookDetails();
            getSelectedBook();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have not selected any book, sorry :(");
            alert.show();
        }
    }

    public void onCheckOut(ActionEvent actionEvent)
    {
    }

    public void onBackToMainPage(ActionEvent actionEvent)
    {
    }

    public void onBackButton(ActionEvent actionEvent)
    {
    }

    public void purchase(ActionEvent actionEvent)
    {
    }
}
