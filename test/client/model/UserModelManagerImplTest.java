package client.model;

import client.network.Client;
import org.junit.Before;
import org.junit.Test;
import shared.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserModelManagerImplTest {

    private UserModelManager userModelManager;

    private Client client;

    @Before
    public void setUp() {
        client = mock(Client.class);

        userModelManager = new UserModelManagerImpl(client);
    }

    /**
     * Should return false when the user is not registered successfully
     */
    @Test
    public void registerBuyerWhenUserIsNotRegisteredSuccessfullyThenReturnFalse() {
        when(client.registerUser(any(User.class))).thenReturn(false);

        boolean isRegistered =
                userModelManager.registerBuyer(
                        "John Doe",
                        "123 Main St",
                        "123-456-7890",
                        "john@doe.com",
                        "johndoe",
                        "password");

        assertFalse(isRegistered);
    }

    /**
     * Should return true when the user is registered successfully
     */
    @Test
    public void registerBuyerWhenUserIsRegisteredSuccessfullyThenReturnTrue() {
        when(client.registerUser(any(User.class))).thenReturn(true);

        boolean isRegistered =
                userModelManager.registerBuyer(
                        "John Doe",
                        "123 Main St",
                        "123-456-7890",
                        "john@doe.com",
                        "johndoe",
                        "password");

        assertTrue(isRegistered);
    }
}