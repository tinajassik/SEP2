package client.views.seller.bookDetails;

import client.core.ViewHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import shared.Author;
import shared.Genre;

import java.util.ArrayList;

public class BookDetailsSellerController {

    @FXML
    private TextField textFieldTitle;
    @FXML
    private TextField textFieldAuthor;
    @FXML
    private TextField textFieldCondition;

    @FXML
    private TextField textFieldCoverType;

    @FXML private TextField textFieldPublicationYear;
    @FXML private TextField textFieldPrice;
    @FXML private TextField textFieldISBN;
    @FXML private Label labelGenres;
    @FXML private ComboBox comboBoxAuthors;

    @FXML private ListView listViewGenres;

    private ArrayList<Genre> selectedGenres;
    private BookDetailsSellerViewModel bookDetailsSellerViewModel;

    public void init(BookDetailsSellerViewModel bookDetailsSellerViewModel) {
        selectedGenres = new ArrayList<>();
        this.bookDetailsSellerViewModel = bookDetailsSellerViewModel;
        this.bookDetailsSellerViewModel.setBook(ViewHandler.getInstance().getMainPageSellerController().sendBookToDetailsView());
        this.bookDetailsSellerViewModel.loadInitialData();
        textFieldAuthor.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.authorProperty());
        textFieldCondition.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.conditionProperty());
        textFieldISBN.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.isbnProperty());
        textFieldPrice.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.priceProperty());
        labelGenres.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.genresProperty());
        textFieldTitle.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.titleProperty());
        textFieldPublicationYear.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.publicationYearProperty());
        textFieldCoverType.textProperty().bindBidirectional(this.bookDetailsSellerViewModel.coverTypeProperty());
        displayAuthors();
        displayGenres();
        listViewGenres.setOnMouseClicked(new EventHandler<Event>() {
            String genres = "";
            @Override
            public void handle(Event event) {
                ObservableList<Genre> selectedItems =  listViewGenres.getSelectionModel().getSelectedItems();

                for(Genre g : selectedItems){
                    System.out.println("selected item " + g.getGenreName());
                    genres += g.getGenreName() +", ";
                    selectedGenres.add(g);
                }
                labelGenres.setText(genres);

            }

        });

        comboBoxAuthors.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (comboBoxAuthors.getSelectionModel().getSelectedItem() != null)
                    textFieldAuthor.setText(comboBoxAuthors.getSelectionModel().getSelectedItem().toString());
            }
        });
    }

    public void displayAuthors() {
        ArrayList<Author> authors = bookDetailsSellerViewModel.getAuthors();

        for (Author author:authors) {
            comboBoxAuthors.getItems().add(author);
        }
    }

    public void displayGenres() {
        ArrayList<Genre> genres = bookDetailsSellerViewModel.loadGenres();
        for (Genre genre: genres
             ) {
            listViewGenres.getItems().add(genre);
        }

    }

    public void onBack() {
        ViewHandler.getInstance().openMainViewSellers();
    }

    public void onDeleteBook() {
        bookDetailsSellerViewModel.deleteBook();
    }

    public void onSave() {
        bookDetailsSellerViewModel.editBook((Author)comboBoxAuthors.getSelectionModel().getSelectedItem(), selectedGenres);
    }
}
