package client.seller.views.addBooksView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddBooksViewModel {

    private StringProperty condition, coverType, Author, isbn, genre, price, yearOfPublication;

    public AddBooksViewModel(){
        this.condition = new SimpleStringProperty();
        this.coverType = new SimpleStringProperty();
        this.Author = new SimpleStringProperty();
        this.isbn = new SimpleStringProperty();
        this.genre = new SimpleStringProperty();
        this.price = new SimpleStringProperty();
        this.yearOfPublication = new SimpleStringProperty();

    }

    public StringProperty conditionProperty() {
        return condition;
    }


    public StringProperty coverTypeProperty() {
        return coverType;
    }


    public StringProperty authorProperty() {
        return Author;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public StringProperty isbnProperty() {
        return isbn;
    }


    public StringProperty genreProperty() {
        return genre;
    }


    public StringProperty priceProperty() {
        return price;
    }


    public StringProperty yearOfPublicationProperty() {
        return yearOfPublication;
    }
}
