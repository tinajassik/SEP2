package client.views.seller.addBooksView;

import client.core.ViewHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Author;
import shared.Genre;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class AddBooksController {

    private AddBooksViewModel addBooksViewModel;
    @FXML
    public ComboBox comboBoxAuthors;
    @FXML
    private ListView listViewGenres;
    @FXML
    public TextField coverType;
    @FXML
    private TextField title;
    @FXML
    public TextField isbn;

    @FXML Label labelGenres;

    @FXML
    public TextField yearOfPublication;

    @FXML
    public Button addBookButton;

    private ArrayList<Genre> selectedGenres;

    public  void init(AddBooksViewModel addBooksViewModel)
    {
        selectedGenres = new ArrayList<>();
        listViewGenres.setOnMouseClicked(new EventHandler<Event>() {
            String genres = "";
            @Override
            public void handle(Event event) {
                ObservableList<Genre> selectedItems =  listViewGenres.getSelectionModel().getSelectedItems();
                for(Genre g : selectedItems){
                    genres += g.getGenreName() +" ";
                    selectedGenres.add(g);
                }
                labelGenres.setText(genres);
            }

        });
        this.addBooksViewModel = addBooksViewModel;
        this.isbn.textProperty().bindBidirectional(addBooksViewModel.isbnProperty());
        this.coverType.textProperty().bindBidirectional(addBooksViewModel.coverTypeProperty());
        this.yearOfPublication.textProperty().bindBidirectional(addBooksViewModel.yearOfPublicationProperty());
        this.title.textProperty().bindBidirectional(addBooksViewModel.titleProperty());
        displayAuthors();
        displayGenres();
    }

    @FXML
    public void addBook(ActionEvent event) {
        if (AreWeAllInThisTogether())
        {
        ViewHandler.getInstance().openAddBookForSaleView();
        System.out.println("Controller Add Book");
        addBooksViewModel.addBook((Author) comboBoxAuthors.getSelectionModel().getSelectedItem(),selectedGenres);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect book information");
            alert.setHeaderText(" ");
            alert.setContentText("You must fill out all fields, \nISBN can not contain letters and be more than 13 digits");
            alert.show();
        }

    }

    public void onBackButton() {

        ViewHandler.getInstance().openMainViewSellers();
    }

    public void displayAuthors() {
        ArrayList<Author> authors = addBooksViewModel.getAuthors();

        for (Author author:authors) {
            comboBoxAuthors.getItems().add(author);
        }
    }

    public void displayGenres() {
        ArrayList<Genre> genres = addBooksViewModel.getGenres();
        for (Genre genre: genres) {
            listViewGenres.getItems().add(genre);
        }
    }

    public boolean AreWeAllInThisTogether(){

        if (comboBoxAuthors.getSelectionModel().isEmpty() ||
                title.getText().isEmpty() ||
                coverType.getText().isEmpty() ||
                isbn.getText().isEmpty() ||
                listViewGenres.getSelectionModel().isEmpty() ||
                yearOfPublication.getText().isEmpty() ||
                isbn.getText().length() != 13 ||
                (!isbn.getText().matches("[0-9]+"))
        )

        {
            return false;
        }
        else return true;
    }

}
