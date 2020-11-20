/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatbot.application.database;

import chatbot.application.utils.ChatbotConstant;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dharma
 */
public class DatabaseHelper {
    public static Connection connection;
    
    public static void openConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection(
                        ChatbotConstant.DATABASE_URL,
                        ChatbotConstant.DATABASE_USERNAME,
                        ChatbotConstant.DATABASE_PASSWORD
                );
            } catch (SQLException e) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public static ResultSet selectQuery(String query) {
        openConnection();
        ResultSet resultSet = null;
        
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return resultSet;
    }
}
