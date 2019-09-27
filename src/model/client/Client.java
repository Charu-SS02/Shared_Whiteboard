package model.client;

import model.remote.IRemoteChat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args){

        System.out.println("Client is starting...");

        try{
            Registry registry = LocateRegistry.getRegistry();

            IRemoteChat remoteChat = (IRemoteChat) registry.lookup("Chat");

            System.out.println("Calling method sendMessage" + remoteChat.sendMessage("test1"));

            System.out.println("Calling method receiveMessage" + remoteChat.receiveMessage("test2"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
