package server.database.book;

import server.database.DatabaseConnection;
import shared.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookGenreDAOImpl implements BookGenreDAO {

    private static BookForSaleDAOImpl instance;

    public synchronized static BookForSaleDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookForSaleDAOImpl();
        }
        return instance;
    }







}
