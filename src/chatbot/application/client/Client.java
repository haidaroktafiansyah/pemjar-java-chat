/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.application.client;

import chatbot.application.server.Server;
import chatbot.application.utils.ChatbotConstant;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author dharm
 */
public class Client extends javax.swing.JFrame {

    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
        
        Server server = new Server();
        server.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textLabelTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        textFieldInputChat = new javax.swing.JTextField();
        buttonSendChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextchat = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabelTitle.setText("Chat Bot");

        buttonSendChat.setText("Send");
        buttonSendChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendChatActionPerformed(evt);
            }
        });

        jTextchat.setEditable(false);
        jScrollPane1.setViewportView(jTextchat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldInputChat, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSendChat))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldInputChat)
                    .addComponent(buttonSendChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendChatActionPerformed
        // TODO add your handling code here:
        try {
            StyledDocument doc = jTextchat.getStyledDocument();

            SimpleAttributeSet right = new SimpleAttributeSet();
            StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
            StyleConstants.setForeground(right, Color.BLUE);

            try {
                doc.insertString(doc.getLength(), "\n" + textFieldInputChat.getText(), right);
                doc.setParagraphAttributes(doc.getLength(), 1, right, false);
            } catch (Exception e) {
                System.out.println(e);
            }

            dataOutputStream.writeUTF(textFieldInputChat.getText());
        } catch (IOException e) {
        }
    }//GEN-LAST:event_buttonSendChatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });

        try {
            socket = new Socket(ChatbotConstant.LOCALHOST, ChatbotConstant.PORT_NUMBER);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String messageIn = "";

            while (!messageIn.equals("exit")) {
                messageIn = dataInputStream.readUTF();

                StyledDocument doc = jTextchat.getStyledDocument();

                SimpleAttributeSet left = new SimpleAttributeSet();
                StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
                StyleConstants.setForeground(left, Color.RED);

                try {
                    doc.insertString(doc.getLength(), "\n" + messageIn, left);
                    doc.setParagraphAttributes(doc.getLength(), 1, left, false);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSendChat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextPane jTextchat;
    private javax.swing.JTextField textFieldInputChat;
    private javax.swing.JLabel textLabelTitle;
    // End of variables declaration//GEN-END:variables
}
