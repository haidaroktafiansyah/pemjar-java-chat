/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatbot.application.server;

import chatbot.application.utils.ChatbotConstant;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dharma
 */
public class Server {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    
    public static void main(String[] args) { 
        String messageIn = "";
        
        try {
            serverSocket = new ServerSocket(ChatbotConstant.PORT_NUMBER);
            socket = serverSocket.accept();
            
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("Server is running");
            
            while(!messageIn.equals("exit")){
                messageIn = dataInputStream.readUTF();
                System.out.println(messageIn);
            }
        } catch (IOException e) {
        }
    }
    
    
}
