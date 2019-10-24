package model.server;

import view.ChatPanel;
import controller.Message;
import model.remote.IRemoteChatClient;
import model.remote.IRemoteChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteChatServer extends UnicastRemoteObject implements IRemoteChatServer {

    private ArrayList<IRemoteChatClient> chatClients;
    ChatPanel chatPanel;

    public RemoteChatServer(ChatPanel chatPanel) throws RemoteException{
//        this.drawPanel= drawPanel;
//        drawClients = new ArrayList<IRemoteDrawClient>();

        this.chatPanel = chatPanel;
        chatClients = new ArrayList<IRemoteChatClient>();

    }

    @Override
    public void registerChatClient(IRemoteChatClient chatClient) throws RemoteException{
        this.chatClients.add(chatClient);
    }

    @Override
    public void addMessage(Message message, boolean broadcast) throws RemoteException{
//        int i =0;
//        while(i < drawClients.size()) {
//            drawPanel.Draw(tool, complete, broadCast);
//            drawClients.get(i++).Draw(tool, complete, broadCast);
//        }

        int i = 0;
        while(i < chatClients.size()){
            chatPanel.addMessage(message, broadcast);
            chatClients.get(i++).addMessage(message, broadcast);
        }
    }
}
