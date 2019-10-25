package model.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.imageio.ImageIO;

import controller.Message;
import controller.State;
import controller.Tool;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;
import view.ChatPanel;
import view.DrawPanel;

public class RemoteDrawClient extends UnicastRemoteObject implements IRemoteDrawClient {
	
	private String name = null;
	DrawPanel drawPanel;
	ChatPanel chatPanel;
	
	public RemoteDrawClient(String name, IRemoteDrawServer drawServer,DrawPanel drawPanel, ChatPanel chatPanel) throws RemoteException {
		this.name = name;
		this.drawPanel = drawPanel;
		this.chatPanel = chatPanel;
		drawServer.registerDrawClient(this,name);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException {
		State.Log("Client Draw Function");
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


	@Override
	public void addMessage(Message message, boolean broadcast) throws RemoteException {

		State.Log("Message Recieved To Client: ");
		State.Log(message.getUsername());
		chatPanel.addMessage(message, broadcast);
        
        State.Log("Message Recieved To client: "+message.getText()+" "+message.getTime());
		
	}

}
