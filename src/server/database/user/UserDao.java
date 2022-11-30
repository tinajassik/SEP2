package server.database.user;

import shared.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    User create(String username, String fullName, String address, String password, String phoneNumber, String email, boolean isSeller) throws SQLException;
    List<String> getAllUsernames() throws SQLException;
    User getUserByUsername(String username) throws SQLException;
}
