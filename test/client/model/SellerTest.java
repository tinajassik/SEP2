package client.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SellerTest {

    private Seller s;

    /**
     *Seller should have a fullname, address, phoneNumber, email, username, password;
     */

    @Test
    public void sellerShouldHaveMandatoryData(){
        s = new Seller("fullName", "address", "phoneNumber", "email", "username", "password");
        assert(s.getFullName().equals("fullName"));
        assert(s.getAddress().equals("address"));
        assert(s.getPhoneNumber().equals("phoneNumber"));
        assert(s.getEmail().equals("email"));
        assert(s.getUsername().equals("username"));
        assert(s.getPassword().equals("password"));
    }

    /**
     * Should have an address
     */

    @Test
    public void sellerShouldHaveAddress(){
        User user = mock(User.class);
        when(user.getAddress()).thenReturn("address");
        String address = user.getAddress();
        assertEquals("address", address);
    }
}