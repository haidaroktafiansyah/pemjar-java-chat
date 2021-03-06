/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.application.server;

import chatbot.application.database.Answer;
import chatbot.application.utils.ChatbotConstant;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dharma
 */
public class Server extends Thread{

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    @Override
    public void run() {
        String messageIn = "";

        try {
            serverSocket = new ServerSocket(ChatbotConstant.PORT_NUMBER);
            socket = serverSocket.accept();

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("Server is running");
            
            dataOutputStream.writeUTF("Hai selamat datang di chatbot, silahkan chat :D");
            
            while (!messageIn.equals("exit")) {
                messageIn = dataInputStream.readUTF(); //get message from client
                Answer answer = new Answer().getByKeyword(messageIn); //get answer from the database
                if (answer.getAnswer() != null) {
                    dataOutputStream.writeUTF(answer.getAnswer());//send it to client
                } else {
                    dataOutputStream.writeUTF("i dont understand");//send it to client
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
