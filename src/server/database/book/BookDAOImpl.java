package server.database.book;


import server.database.DatabaseConnection;
import shared.Author;
import shared.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private static BookDAOImpl instance;

    public static synchronized BookDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new BookDAOImpl();
        }
        return instance;
    }


    @Override
    public Book create(String isbn, String title, String genre, String condition, String coverType, Author author, int yearOfPublishing, double price) throws SQLException {
        try(Connection connection = DatabaseConnection.getInstance().getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO Book(isbn, title, publication_year, cover_type, author_id) VALUES (?, ?, ?, ?,?);");
            statement.setString(1, isbn);
            statement.setString(2, title);
            statement.setInt(3, yearOfPublishing);
            statement.setString(4, coverType);
            statement.setInt(5,author.getId());
            statement.executeUpdate();
            return new Book(isbn, title, yearOfPublishing, coverType, author);
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
