package client.network;

import org.junit.Before;
import org.junit.Test;
import shared.network.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RMIClientImplTest {

    private RMIClientImpl rmiClient;
    private RMIServer server;
    private Registry registry;

    @Before
    public void setUp() throws Exception {
        rmiClient = new RMIClientImpl();
        server = mock(RMIServer.class);
        registry = mock(Registry.class);
        when(registry.lookup("Server")).thenReturn(server);
        when(LocateRegistry.getRegistry("localhost", 1992)).thenReturn(registry);
    }

    /**
     * Should set the server to the server in the registry when the server is found
     */
    @Test
    public void startClientWhenServerIsFoundThenSetServerToServerInRegistry() {
        rmiClient.startClient();
        assertEquals(server, rmiClient.getServer());
    }

    /**
     * Should throw an exception when the server is not found
     */
    @Test
    public void startClientWhenServerIsNotFoundThenThrowException() {
        try {
            when(LocateRegistry.getRegistry("localhost", 1992)).thenThrow(new RemoteException());
            rmiClient.startClient();
        } catch (RemoteException e) {
            assertEquals("Server not found", e.getMessage());
        }
    }
}