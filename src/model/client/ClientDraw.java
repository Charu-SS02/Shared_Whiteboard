package model.client;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import controller.State;
import model.remote.IRemoteDraw;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;
import model.server.RemoteDraw;
import model.server.RemoteDrawClient;
import model.server.RemoteDrawServer;
import view.DrawPanel;

public class ClientDraw {

	
	public ClientDraw(DrawPanel dpanel, String ip, String port) throws AlreadyBoundException, NotBoundException {
	
	Registry registry;
	try 
	{
		int portInt = Integer.parseInt(port);
		registry = LocateRegistry.getRegistry(ip, portInt);
//        registry = LocateRegistry.getRegistry("localhost");

		IRemoteDrawServer remoteChat = (IRemoteDrawServer) registry.lookup("DrawMethod");
			
		IRemoteDrawClient cw =  new RemoteDrawClient("a",remoteChat,dpanel);
		
	} catch (Exception e) {
		State.ShowErrors(e, "ClientDraw - Client Draw");

	} 
    
    State.Log("Draw server ready");
}
}
