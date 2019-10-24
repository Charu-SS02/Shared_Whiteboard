package model.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controller.State;
import controller.Tool;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;
import view.DrawPanel;

public class RemoteDrawServer extends UnicastRemoteObject implements IRemoteDrawServer{

	/**
	 * 
	 */
	private ArrayList<IRemoteDrawClient> drawClients;
	DrawPanel drawPanel;

	public RemoteDrawServer(DrawPanel drawPanel) throws RemoteException {
		this.drawPanel= drawPanel; 
		drawClients = new ArrayList<IRemoteDrawClient>();
	}
	@Override
	public void registerDrawClient(IRemoteDrawClient drawClient) throws RemoteException {
		// TODO Auto-generated method stub
		this.drawClients.add(drawClient);
	}
	@Override
	public void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException {
		// TODO Auto-generated method stub
		int i =0;
		while(i < drawClients.size()) {
			drawPanel.Draw(tool, complete, broadCast);
			drawClients.get(i++).Draw(tool, complete, broadCast);
		}
	}
	@Override
	public void Sync(byte[] rawImage, Boolean broadCast) throws RemoteException {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new ByteArrayInputStream(rawImage));
			int i =0;
			while(i < drawClients.size()) {
				drawPanel.UpdateMainImage(img);
				drawClients.get(i++).Sync(rawImage);
			}
			
		} catch (IOException e) {
			State.Log(e.getMessage());
		}
		
		
		State.Log("Clear Undo Redo Here: RemoteDrawServer");
		
	}


}
