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
import view.DrawPanel;

public class ServerDraw {
	
	public ServerDraw(DrawPanel dpanel) 
	{
		IRemoteDrawServer remoteDraw;
		Registry registry;
		try 
		{	
			//Naming.rebind("DrawMethod", new RemoteDrawServer(dpanel));
			remoteDraw = new RemoteDrawServer(dpanel);
			registry = LocateRegistry.getRegistry();
			registry.bind("DrawMethod", remoteDraw);
		} catch (AccessException e) {
			System.out.println(e);
			State.ErrorLog(e.getMessage());
			State.ErrorLog(e.getStackTrace().toString());
		} catch (RemoteException e) {
			System.out.println(e);
			State.ErrorLog(e.getMessage());
			State.ErrorLog(e.getStackTrace().toString());
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    State.Log("Draw server ready");
	}
}
