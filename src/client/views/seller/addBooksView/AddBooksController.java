package client.views.seller.addBooksView;

import client.core.ViewHandler;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Author;
import shared.Genre;

import java.util.ArrayList;

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
//        listViewGenres.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
        ViewHandler.getInstance().openAddBookForSaleView();
        System.out.println("Controller Add Book");
        addBooksViewModel.addBook((Author) comboBoxAuthors.getSelectionModel().getSelectedItem(),selectedGenres);
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


}
