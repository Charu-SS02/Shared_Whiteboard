package controller;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import model.remote.IRemoteDrawServer;
import model.server.RemoteDrawServer;
import view.ChatPanel;
import view.DrawPanel;

public class ServerDraw {
	
	public ServerDraw(DrawPanel dpanel,ChatPanel chatPanel, String ip, String port)
	{
		IRemoteDrawServer remoteDraw;
		Registry registry;
		try 
		{
			int portInt = Integer.parseInt(port);
			// create registry
			LocateRegistry.createRegistry(portInt);
			
			State.Log(chatPanel.getName());
			
			remoteDraw = new RemoteDrawServer(dpanel,chatPanel);
			
			registry = LocateRegistry.getRegistry(ip, portInt);
			registry.bind("DrawMethod", remoteDraw);

//			//Naming.rebind("DrawMethod", new RemoteDrawServer(dpanel));
//			remoteDraw = new RemoteDrawServer(dpanel);
//			registry = LocateRegistry.getRegistry();
//			registry.bind("DrawMethod", remoteDraw);
		} catch (Exception e) {
			State.ShowErrors(e, "ServerDraw - constructor");
		}
	    State.Log("Draw server ready");
	}
}
