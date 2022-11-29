package server.database.user;

import shared.User;

import java.sql.SQLException;

public interface UserDao {

    User create(String username, String fullName, String address, String password, String phoneNumber, String email, boolean isSeller) throws SQLException;
}
