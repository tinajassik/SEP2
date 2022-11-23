package client.model;

public interface UserModelManager {

    void registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password);
    void registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password);
    User getUser(String username);

}
