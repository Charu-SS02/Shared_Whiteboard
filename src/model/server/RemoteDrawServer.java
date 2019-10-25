package model.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import controller.Message;
import controller.State;
import controller.Tool;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;
import view.ChatPanel;
import view.DrawPanel;

public class RemoteDrawServer extends UnicastRemoteObject implements IRemoteDrawServer{

	/**
	 * 
	 */
	private ArrayList<IRemoteDrawClient> drawClients;
	DrawPanel drawPanel;
	ChatPanel chatPanel;
	Map<String, String> userList = new HashMap<String, String>();

	public RemoteDrawServer(DrawPanel drawPanel, ChatPanel chatPanel) throws RemoteException {
		this.drawPanel= drawPanel; 
		this.chatPanel = chatPanel;
		drawClients = new ArrayList<IRemoteDrawClient>();
	}
	@Override
	public void registerDrawClient(IRemoteDrawClient drawClient,String uname) throws RemoteException {
		
		State.Log("Registering a Client "+uname);
		
		this.drawClients.add(drawClient);
		userList.put("username", uname);
		System.out.println(userList.size());
	
	}
	@Override
	public void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException {
		
		State.Log("Client Lists: "+drawClients.size());
    	State.Log("Server Broadcasting the draw Request "+tool.type);
		
		int i =0;
		while(i < drawClients.size()) {
			drawPanel.Draw(tool, complete, broadCast);
			drawClients.get(i++).Draw(tool, complete, broadCast);
		}
	}
	@Override
	public void Sync(byte[] rawImage, Boolean broadCast) throws RemoteException {

		State.Log(" Sync");
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
		
		
		State.Log("Clear Undo Redo Here: RemoteDrawServer 1");
		
	}
	@Override
	public void RequestSync(Boolean broadCast) throws RemoteException {

		State.Log("Request Sync");
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try 
		{
			ImageIO.write(drawPanel.DeepCopyOfMainImage(), "jpg", outputStream);
			int i =0;
			
			while(i < drawClients.size()) 
			{
				drawClients.get(i++).Sync(outputStream.toByteArray());
			}
			
		} catch (IOException e) {
			State.Log(e.getMessage());
		}
		
		
		State.Log("Clear Undo Redo Here: RemoteDrawServer 2");
		
	}
	
	@Override
	public void addMessage(Message message, boolean broadcast) throws RemoteException{

		State.Log("Client Lists: "+drawClients.size());
    	State.Log("Server Broadcasting the message "+message.getText());
    	
        int i = 0;
        while(i < drawClients.size()){
        	State.Log("M 1");
        	chatPanel.addMessage(message, broadcast);
        	State.Log("M 2");
        	drawClients.get(i++).addMessage(message, broadcast);
        	State.Log("M3");
        }
		
	}


}
