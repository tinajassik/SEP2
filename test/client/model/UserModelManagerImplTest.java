package client.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserModelManagerImplTest {

    private UserModelManager userModelManager;

    @Before
    public void setUp() {
        userModelManager = new UserModelManagerImpl();
    }

    /**
     * Should throw an exception when the username is already taken
     */
    @Test
    public void registerBuyerWhenUsernameIsAlreadyTakenThenThrowException() {
        userModelManager.registerBuyer(
                "John Doe", "123 Main St", "123-456-7890", "john@doe.com", "johndoe", "password");
        try {
            userModelManager.registerBuyer(
                    "Jane Doe",
                    "123 Main St",
                    "123-456-7890",
                    "jane@doe.com",
                    "johndoe",
                    "password");
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Username already taken", e.getMessage());
        }
    }

    /**
     * Should add a buyer to the list of registered users
     */
    @Test
    public void registerBuyerShouldAddABuyerToTheListOfRegisteredUsers() {
        String fullName = "John Doe";
        String address = "123 Fake Street";
        String phoneNumber = "123-456-7890";
        String email = "john.doe@gmail.com";
        String username = "johndoe";
        String password = "password";

        userModelManager.registerBuyer(fullName, address, phoneNumber, email, username, password);

        assertTrue(userModelManager.validateUser(username));
    }
}