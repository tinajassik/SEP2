package server.database.user;

import shared.Order;

import java.sql.SQLException;

public interface OrderDAO {
  void createOrder(Order order) throws SQLException;


}
