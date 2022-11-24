package client.model;

import org.junit.Test;

public class SellerTest {

    private Seller s;

    @Test
    public void Seller(){
        s = new Seller("fullName", "address", "phoneNumber", "email", "username", "password");
        assert(s.getFullName().equals("fullName"));
        assert(s.getAddress().equals("address"));
        assert(s.getPhoneNumber().equals("phoneNumber"));
        assert(s.getEmail().equals("email"));
        assert(s.getUsername().equals("username"));
        assert(s.getPassword().equals("password"));
    }

    @Test
    public void getFullName(){
        s = new Seller("fullName", "address", "phoneNumber", "email", "username", "password");
        assert(s.getFullName().equals("fullName"));
//        return s.getFullName();
    }
}