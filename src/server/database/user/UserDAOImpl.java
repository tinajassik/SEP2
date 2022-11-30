package server.database.user;

import server.database.DatabaseConnection;
import shared.Buyer;
import shared.Seller;
import shared.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, full_name, address, password, phone_number, email, is_seller) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,fullName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5,phoneNumber);
            preparedStatement.setString(6,email);
            preparedStatement.setBoolean(7,isSeller);
            preparedStatement.executeUpdate();
            User user;

            if (isSeller) user = new Seller(fullName, address, phoneNumber, email, username, password);
            else user = new Buyer(fullName, address, phoneNumber, email, username, password);

            return user;
        }

    }

    @Override
    public List<String> getAllUsernames() throws SQLException {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> allUsernames = new ArrayList<>();
            while (resultSet.next()) {
                allUsernames.add(resultSet.getString("username"));
            }
            return allUsernames;
        }
    }

    @Override
    public User getUserByUsername(String username) throws SQLException {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                boolean isSeller = resultSet.getBoolean("is_seller");

                if (isSeller) return  new Seller(fullName,address,phoneNumber,email,username,password);
                else return  new Buyer(fullName,address,phoneNumber,email,username,password);
            }
            else return null ;
        }
    }

}
