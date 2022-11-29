package server.database.user;

import server.database.DatabaseConnection;
import shared.Buyer;
import shared.Seller;
import shared.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDao{

    private static UserDAOImpl instance;

    public synchronized static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public User create(String username, String fullName, String address, String password, String phoneNumber, String email, boolean isSeller) throws SQLException {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, full_name, address, password, phone_number, is_seller) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,fullName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5,phoneNumber);
            preparedStatement.setString(6,email);
            preparedStatement.setBoolean(7,isSeller);
        }

        User user;

        if (isSeller) user = new Seller(fullName, address, phoneNumber, email, username, password);
        else user = new Buyer(fullName, address, phoneNumber, email, username, password);

        return user;

    }
}
