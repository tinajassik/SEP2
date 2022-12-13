package client.core;

import client.network.Client;
import client.network.RMIClientImpl;

import java.rmi.RemoteException;

public class ClientFactory {

        private static ClientFactory instance;

        public static ClientFactory getInstance(){
            if (instance == null) {
                instance = new ClientFactory();
            }
            return instance;
        }

        private Client client;

        private ClientFactory() {
        }

        public Client getClient()  {
            if (client == null) {
                    client = new RMIClientImpl();
            }
            return client;
        }
    }

