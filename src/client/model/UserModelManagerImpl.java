package client.model;


import java.util.HashMap;

public class UserModelManagerImpl implements UserModelManager {

    HashMap<String, User> allRegisteredUsers = new HashMap<>();

    @Override
    public void registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password) {
        allRegisteredUsers.put(username,new Buyer(fullName, address, phoneNumber, email, username, password)) ;
    }

    @Override
    public void registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password) {
        allRegisteredUsers.put(username,new Seller(fullName, address, phoneNumber, email, username, password)) ;
    }

    @Override
    public User getUser(String username) {
        return allRegisteredUsers.get(username);
    }


}
