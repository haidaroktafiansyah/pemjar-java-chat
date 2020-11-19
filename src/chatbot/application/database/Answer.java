/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot.application.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dharma
 */
public class Answer {
    
    private String keyword;
    private String answer;

    public Answer() {
    }

    public Answer(String key, String answer) {
        this.keyword = key;
        this.answer = answer;
    }
    
    public String getKey() {
        return keyword;
    }

    public void setKey(String key) {
        this.keyword = key;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer getByKeyword(String keyword) {
        Answer answer = new Answer();
        ResultSet resultSet
                = DatabaseHelper.selectQuery(
                        "SELECT * FROM answers WHERE keyword = '" + keyword + "'"
                ); 

        try {
            while (resultSet.next()) {
                answer = new Answer();
                answer.setKey(resultSet.getString("keyword"));
                answer.setAnswer(resultSet.getString("answer"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, e);
        }

        return answer;
    }
}
