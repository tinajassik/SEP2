package client.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuyerTest {

    private Buyer b;

    /**
    *Buyer should have a fullname, address, phoneNumber, email, username, password;
     */

    @Test
    public void buyerShouldHaveMandatoryData() {
        b = new Buyer("fullName", "address", "phoneNumber", "email", "username", "password");
        assert (b.getFullName().equals("fullName"));
        assert (b.getAddress().equals("address"));
        assert (b.getPhoneNumber().equals("phoneNumber"));
        assert (b.getEmail().equals("email"));
        assert (b.getUsername().equals("username"));
        assert (b.getPassword().equals("password"));
    }

    /**
     * Should have an address
     */
    @Test
    public void buyerShouldHaveAddress() {
        User user = mock(User.class);
        when(user.getAddress()).thenReturn("address");
        String address = user.getAddress();
        assertEquals("address", address);
    }
}