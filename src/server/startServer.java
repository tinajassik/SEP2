package server;

import server.network.RMIServerImpl;

public class startServer
{
  public static void main(String[] args)
  {
    RMIServerImpl server = new RMIServerImpl();
    server.startServer();
  }
}
