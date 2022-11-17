package server.dao;


import shared.Author;
import shared.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private static BookDAOImpl instance;
    private BookDAOImpl() throws  SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized BookDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new BookDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=book_store", "postgres", "tina");
    }


    @Override
    public Book create(String isbn, String title, String genre, String condition, String coverType, Author author, int yearOfPublishing, double price) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO Book(isbn, title, genre, condition, cover_type, author_id, price, yearOfPublishing) VALUES (?, ?, ?, ?,?,?,?,?);");
            statement.setString(1, isbn);
            statement.setString(2, title);
            statement.setString(3, genre);
            statement.setString(4, condition);
            statement.setString(5, coverType);
            statement.setInt(6,author.getId());
            statement.setDouble(7, price);
            statement.setInt(8, yearOfPublishing);
            statement.executeUpdate();
            return new Book(isbn, title, genre,condition, coverType, author, yearOfPublishing, price);
        }
    }

    @Override
    public Book readByISBN(String isbn) throws SQLException {
        return null;
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        return null;
    }

    @Override
    public List<Book> readByTitle(String searchString) throws SQLException {
        return null;
    }

    @Override
    public List<Book> readByGenre(String genre) throws SQLException {
        return null;
    }

    @Override
    public List<Book> readByAuthor(Author author) throws SQLException {
        return null;
    }

    @Override
    public void update(Book book) throws SQLException {

    }

    @Override
    public void delete(Book book) throws SQLException {

    }
}
