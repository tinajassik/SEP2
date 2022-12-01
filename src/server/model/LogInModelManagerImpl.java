package server.model;

import server.database.user.UserDAOImpl;
import server.database.user.UserDao;
import shared.User;

import java.sql.SQLException;



public class LogInModelManagerImpl implements LogInModelManager {

    private UserDao userDao;

    public LogInModelManagerImpl() {
        userDao = UserDAOImpl.getInstance();
    }

    // check if the username is already taken when registering a new user
    // (or if it exists when logging in)
    @Override
    public boolean validateUsername(String username) {
        try {
            System.out.println(userDao.getAllUsernames());
            System.out.println("I'm here");
            return userDao.getAllUsernames().contains(username);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database");
        }
    }


    // check user's password in order to log in
    @Override
    public boolean validatePassword(String username, String password)  {
        try {
            return password.equals(userDao.getUserByUsername(username).getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("SQL exception");
        }
    }

    @Override
    public boolean registerBuyer(User user)  {
        boolean registrationSuccessful = false;

        if (!(validateUsername(user.getUsername()))) {
            try {
                userDao.create(user.getUsername(), user.getFullName(), user.getAddress(), user.getPassword(), user.getPhoneNumber(), user.getEmail(), false);
                System.out.println("New buyer saved in the database");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            registrationSuccessful = true;
        }
        return registrationSuccessful;
    }

    @Override
    public boolean registerSeller(User user) {
        boolean registrationSuccessful = false;
        System.out.println("in login model manager - server side - before if");
        if (!(validateUsername(user.getUsername()))) {

            try {
                System.out.println("in login model manager - server side - after if");
                userDao.create(user.getUsername(), user.getFullName(), user.getAddress(), user.getPassword(), user.getPhoneNumber(), user.getEmail(), true);
                System.out.println("New seller saved in the database");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            registrationSuccessful = true;
        }
        return registrationSuccessful;
    }

    @Override
    public User getUser(String username){
        try
        {
            return userDao.getUserByUsername(username);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
