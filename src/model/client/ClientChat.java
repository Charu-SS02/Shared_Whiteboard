package model.client;

import view.ChatPanel;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import controller.State;
import model.remote.IRemoteChatServer;
import model.remote.IRemoteChatClient;
import model.server.RemoteChatClient;

public class ClientChat {

    public ClientChat(ChatPanel chatPanel) throws AlreadyBoundException, NotBoundException{
        Registry registry;
        try{
            registry = LocateRegistry.getRegistry();

            IRemoteChatServer remoteChat = (IRemoteChatServer) registry.lookup("DrawMethod");

            IRemoteChatClient cw =  new RemoteChatClient("a",remoteChat,chatPanel);
        }catch(Exception e){

        }
        State.Log("Chat server ready");
    }
}
