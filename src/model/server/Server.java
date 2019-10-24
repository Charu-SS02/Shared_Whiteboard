package model.server;

import model.remote.IRemoteChat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args){
        System.out.println("Server is starting...");

        try{
            IRemoteChat remoteChat = new RemoteChat();

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Chat", remoteChat);

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Serve is ready");
    }
}
