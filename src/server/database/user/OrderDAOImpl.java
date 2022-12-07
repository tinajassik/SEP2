package server.database.user;


import server.database.DatabaseConnection;

import java.sql.Connection;

public class OrderDAOImpl implements OrderDAO {

    private static OrderDAOImpl instance;
    private Connection connection;

    public synchronized static OrderDAOImpl getInstance() {
        if (instance == null) {
            instance = new OrderDAOImpl();
        }
        return instance;
    }

    private OrderDAOImpl() {
        connection = DatabaseConnection.getInstance().getConnection();
    }
}
