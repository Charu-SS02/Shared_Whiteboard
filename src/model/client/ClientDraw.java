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

	
	public ClientDraw(DrawPanel dpanel) throws AlreadyBoundException, NotBoundException {
	
	Registry registry;
	try 
	{
		
        registry = LocateRegistry.getRegistry("localhost");
//        
//		//Retrieve the stub/proxy for the remote math object from the registry
		
//		remoteDraw = (IRemoteDrawServer) registry.lookup("DrawMethod");
//		IRemoteDrawClient cw =  new RemoteDrawClient("a",remoteDraw,dpanel);
		
        //Registry registry1 = LocateRegistry.getRegistry();

			//Naming.rebind("DrawMethod", new RemoteDrawServer(dpanel));
			//remoteDraw = new RemoteDrawServer(dpanel);
		IRemoteDrawServer remoteChat = (IRemoteDrawServer) registry.lookup("DrawMethod");
			
		IRemoteDrawClient cw =  new RemoteDrawClient("a",remoteChat,dpanel);
		
	} catch (Exception e) {
		State.ErrorLog(e.getMessage());
		State.ErrorLog(e.getStackTrace().toString());
	} 
    
    State.Log("Draw server ready");
}
}
