package server.model;

import server.database.book.BookDAO;
import server.database.book.BookDAOImpl;
import server.database.book.BookForSaleDAO;
import server.database.book.BookForSaleDAOImpl;
import shared.Book;
import shared.BookForSale;
import shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class StoreModelManagerImpl implements StoreModelManager{

    private BookDAO bookDAO;
    private BookForSaleDAO bookForSaleDAO;
    private PropertyChangeSupport propertyChangeSupport;

    public StoreModelManagerImpl() throws SQLException {
        bookDAO = BookDAOImpl.getInstance();
        bookForSaleDAO = BookForSaleDAOImpl.getInstance();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public BookForSale addBookForSale(String condition, double price, Book book, User user) {
        try {
            BookForSale bookForSale = BookForSaleDAOImpl.getInstance().create(condition,price, book, user);
            propertyChangeSupport.firePropertyChange("NewBookForSale", null, bookForSale);
            return bookForSale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AddBook(Book book) {
        try {
            System.out.println("Store Model Manager");
            if (bookDAO.readByISBN(book.getIsbn()) == null) {
                bookDAO.create(book.getIsbn(),book.getTitle(),book.getCoverType(), book.getAuthor(), book.getYearOfPublish(), book.getGenre());
            }
            else {
                //do nothing, because the book is already in the database
                // and we do not need to crate another one
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookForSale> getBooks() {
        return bookForSaleDAO.getAllBooks();
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);
    }
}
