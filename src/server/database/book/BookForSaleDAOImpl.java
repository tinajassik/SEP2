package server.database.book;

import java.sql.SQLException;

public class BookForSaleDAOImpl implements BookForSaleDAO {

    private static BookForSaleDAOImpl instance;

    public static synchronized BookForSaleDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new BookForSaleDAOImpl();
        }
        return instance;
    }


}
