/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Tzipi Shwetz
 */
public class ServerS {

    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
        System.out.println("Waiting for the client message...");
        //creating socket and waiting for client connection
        Socket socket = server.accept();
        //read from socket to ObjectInputStream object
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //convert ObjectInputStream object to String
        String message = (String) ois.readObject();
        System.out.println("Message Received from the client: " + message);
        //create ObjectOutputStream object
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        //write object to Socket
        System.out.print("Write message to the client:  ");
        oos.writeObject(s.next());             
        //terminate the server if client sends exit request
        }
    }
}

