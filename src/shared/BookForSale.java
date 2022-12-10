package shared;

import java.io.Serializable;

public class BookForSale implements Serializable {

    private int id;
    private String condition;
    private double price;
    private Book book;
    private User user; //sold By

    private String username; // seller id
    private String isbn; // book generic id


    public BookForSale(int id, String condition, double price, Book book, User user) {
        this.id = id;
        this.condition = condition;
        this.price = price;
        this.book = book;
        this.user = user;
    }

    public BookForSale(int id, String condition, double price, String isbn, String sellerId) {
        this.id = id;
        this.condition = condition;
        this.price = price;
        this.username = sellerId;
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }

    public String getSellerID() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "Title: " + book.getTitle() + "\nAuthor:" + book.getAuthor().toString()
                + "\nPrice: " + price + "$" + "\nCondition: " + condition;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BookForSale)) return false;

        if (id == ((BookForSale) obj).getId()) return true;

        else return false;
    }
}
