package client.model;

import util.Subject;

public interface UserModelManager extends Subject {

    void registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password);
    void registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password);
    User getUser(String username);
    boolean validatePassword(String username, String password);
    boolean validateUser(String username);

}
