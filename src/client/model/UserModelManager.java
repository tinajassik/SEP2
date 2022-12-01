package client.model;

import shared.User;
import util.Subject;

public interface UserModelManager extends Subject {

    boolean registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password);
    boolean registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password);
    User getUser();
    boolean validatePassword(String username, String password) throws IllegalAccessException;
    boolean validateUser(String username);
    User getUserType(String username);
}
