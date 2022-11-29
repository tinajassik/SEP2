package server.database.book;

public class BookGenreDAOImpl implements BookGenreDAO {

    private static BookForSaleDAOImpl instance;

    public synchronized static BookForSaleDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookForSaleDAOImpl();
        }
        return instance;
    }






}
