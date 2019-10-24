package model.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.imageio.ImageIO;

import controller.State;
import controller.Tool;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;
import view.DrawPanel;

public class RemoteDrawClient extends UnicastRemoteObject implements IRemoteDrawClient {
	
	/**
	 * 
	 */
	private IRemoteDrawServer drawServer;
	private String name = null;
	DrawPanel drawPanel;

	public RemoteDrawClient(String name, IRemoteDrawServer drawServer,DrawPanel drawPanel) throws RemoteException {
		this.name = name;
		this.drawServer = drawServer;
		this.drawPanel = drawPanel;
		drawServer.registerDrawClient(this);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException {
		System.out.println(complete);
		drawPanel.Draw(tool, complete, broadCast);
		
	}
	
	@Override
	public void Sync(byte[] rawImage) throws RemoteException {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new ByteArrayInputStream(rawImage));
		} catch (IOException e) {
			State.Log(e.getMessage());
		}
		drawPanel.UpdateMainImage(img);
		
		State.Log("Clear Undo Redo Here: RemoteDrawServer");
		
	}

}
