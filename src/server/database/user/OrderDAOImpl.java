package server.database.user;


public class OrderDAOImpl implements OrderDAO {

    private static OrderDAOImpl instance;

    public synchronized static OrderDAOImpl getInstance() {
        if (instance == null) {
            instance = new OrderDAOImpl();
        }
        return instance;
    }
}
