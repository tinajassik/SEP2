package client.model;

import org.junit.Test;

public class BuyerTest {

    private Buyer b;

    @Test
    public void Buyer() {
        b = new Buyer("fullName", "address", "phoneNumber", "email", "username", "password");
        assert (b.getFullName().equals("fullName"));
        assert (b.getAddress().equals("address"));
        assert (b.getPhoneNumber().equals("phoneNumber"));
        assert (b.getEmail().equals("email"));
        assert (b.getUsername().equals("username"));
        assert (b.getPassword().equals("password"));
    }

    @Test
    public void getFullName() {
        b = new Buyer("fullName", "address", "phoneNumber", "email", "username", "password");
        assert (b.getFullName().equals("fullName"));

    }
}