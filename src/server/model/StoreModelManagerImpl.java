package server.model;

import server.database.book.*;
import shared.Book;
import shared.BookForSale;
import shared.Genre;
import shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreModelManagerImpl implements StoreModelManager{

    private BookDAO bookDAO;
    private BookForSaleDAO bookForSaleDAO;
    private PropertyChangeSupport propertyChangeSupport;
    private GenreDAO genreDAO;

    public StoreModelManagerImpl() throws SQLException {
        bookDAO = BookDAOImpl.getInstance();
        bookForSaleDAO = BookForSaleDAOImpl.getInstance();
        propertyChangeSupport = new PropertyChangeSupport(this);
        genreDAO = GenreDAOImpl.getInstance();
    }

    @Override
    public BookForSale addBookForSale(String condition, double price, Book book, User user) {
        try {
            BookForSale bookForSale = BookForSaleDAOImpl.getInstance().create(condition,price, book, user);
            ArrayList<Genre> genres = book.getGenre();
            for (Genre genre: genres)
            {
                BookGenreDAOImpl.getInstance().create(genre.getGenreName(), book.getIsbn());

            }
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

    @Override public List<BookForSale> getBooksByTile(String title)
    {
        return bookForSaleDAO.getBooksByTitle(title);
    }

    @Override public ArrayList<Genre> getAllGenres()
    {
        try
        {
            return genreDAO.getAllGenres();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override public List<BookForSale> getBooksByGenre(String genre)
    {
        return bookForSaleDAO.getBooksByGenre(genre);
    }

    @Override public List<BookForSale> getBookByAuthor(String authorFName, String authorLName)
    {
        return bookForSaleDAO.getBooksByAuthor(authorFName, authorLName);
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
