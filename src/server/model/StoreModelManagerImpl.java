package server.model;

import server.database.book.*;
import server.database.user.OrderDAO;
import server.database.user.OrderDAOImpl;
import server.database.user.UserDAOImpl;
import server.database.user.UserDao;
import shared.*;

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
    private AuthorDAO authorDAO;
    private OrderDAO orderDAO;
    private UserDao userDAO;

    public StoreModelManagerImpl() throws SQLException {
        bookDAO = BookDAOImpl.getInstance();
        bookForSaleDAO = BookForSaleDAOImpl.getInstance();
        propertyChangeSupport = new PropertyChangeSupport(this);
        genreDAO = GenreDAOImpl.getInstance();
        authorDAO = AuthorDAOImpl.getInstance();
        orderDAO = OrderDAOImpl.getInstance();
        userDAO = UserDAOImpl.getInstance();
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
                ArrayList<Genre> genres = book.getGenre();
                for (Genre genre: genres)
                {
                    BookGenreDAOImpl.getInstance().create(genre.getGenreName(), book.getIsbn());

                }
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
        try {
            List<BookForSale> booksFromDTBS = bookForSaleDAO.getAllBooks();
            return convertBookList(booksFromDTBS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookForSale> getBooksSoldBy(String id) {
        try {
            List<BookForSale> booksFromDTBS = bookForSaleDAO.getBooksSoldBy(id);
            return convertBookList(booksFromDTBS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BookForSale> convertBookList(List<BookForSale> booksFromDTBS) {
        List<BookForSale> booksToDisplay = new ArrayList<>();
        for (BookForSale book : booksFromDTBS) {
            try {
                booksToDisplay.add(new BookForSale(book.getId(), book.getCondition(), book.getPrice(), bookDAO.readByISBN(book.getISBN()), UserDAOImpl.getInstance().getUserByUsername(book.getSellerID())));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return booksToDisplay;
    }
    @Override
    public void editBook(String condition, double price, Book book, String username) {
        try {
            BookDAOImpl.getInstance().update(book);
            BookForSaleDAOImpl.getInstance().update(condition,price, book.getIsbn(), username);
            BookGenreDAOImpl.getInstance().update(book.getIsbn(), book.getGenre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteBook(int id) {
        try {
            BookForSale bookFROMDTBS = BookForSaleDAOImpl.getInstance().delete(id);
            BookForSale deletedBook = new BookForSale(bookFROMDTBS.getId(), bookFROMDTBS.getCondition(), bookFROMDTBS.getPrice(), bookDAO.readByISBN(bookFROMDTBS.getISBN()), userDAO.getUserByUsername(bookFROMDTBS.getSellerID()));
            System.out.println("in delete book in store model manager");
            propertyChangeSupport.firePropertyChange("BookForSaleDeleted", null, deletedBook);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void purchase(ArrayList<BookForSale> booksToBeSold) {
        for (BookForSale book: booksToBeSold) {
            try {
                bookForSaleDAO.changePrice(book.getId());
                propertyChangeSupport.firePropertyChange("BookForSaleDeleted", null, book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override public void createOrder(Order order)
    {
        try
        {
            System.out.println("I'm in the store model manager");
            orderDAO.createOrder(order);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override public List<BookForSale> getBooksByTile(String title)
    {
        return convertBookList(bookForSaleDAO.getBooksByTitle(title));
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

    @Override public ArrayList<Author> getAllAuthors()
    {
        try
        {
            return authorDAO.getAllAuthors();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override public List<BookForSale> getBooksByGenre(String genre)
    {
        return convertBookList(bookForSaleDAO.getBooksByGenre(genre));
    }

    @Override public List<BookForSale> getBookByAuthor(String authorFName, String authorLName)
    {

        return convertBookList(bookForSaleDAO.getBooksByAuthor(authorFName, authorLName));
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
