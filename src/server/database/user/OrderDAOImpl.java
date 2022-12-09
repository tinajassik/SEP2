package server.database.user;


import server.database.DatabaseConnection;
import shared.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {

    private static OrderDAOImpl instance;
    private Connection connection;

    public synchronized static OrderDAOImpl getInstance() {
        if (instance == null) {
            instance = new OrderDAOImpl();
        }
        return instance;
    }

    private OrderDAOImpl()
    {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override public void createOrder(Order order) throws SQLException
    {
        try(Connection connection = DatabaseConnection.getInstance().getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders(book_id, seller_id, buyer_id) VALUES (?, ?, ?);");
            preparedStatement.setInt(1, order.getSoldBookId());
            preparedStatement.setString(2,order.getSellerUsername());
            preparedStatement.setString(3, order.getBuyerUsername());
            preparedStatement.executeUpdate();
        }
    }


    }

