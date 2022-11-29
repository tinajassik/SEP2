package client.network;

import org.junit.Before;
import org.junit.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RMIClientImplTest {

    private RMIClientImpl rmiClient;

    @Before
    public void setUp() {
        rmiClient = new RMIClientImpl();
    }

    /**
     * Should throw an exception when the server is not available
     */
    @Test
    public void startClientShouldThrowExceptionWhenServerIsNotAvailable() {
        try {
            rmiClient.startClient();
            fail("Should throw exception when server is not available");
        } catch (Exception e) {
            assertTrue(e instanceof RemoteException);
        }
    }

    /**
     * Should connect to the server
     */
    @Test
    public void startClientShouldConnectToTheServer() {
        try {
            Registry registry = mock(Registry.class); // Create a mock registry object to return when the server is looked up in the registry
            RMIServer server = mock(RMIServer.class);
            when(registry.lookup("Server")).thenReturn(server);
            when(LocateRegistry.getRegistry("localhost", 1099)).thenReturn(registry);
            rmiClient.startClient(); // Start the client and connect to the server
            assertEquals(server, rmiClient.getServer()); // Check if the server is set correctly in the client object after connecting to the server successfully
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}