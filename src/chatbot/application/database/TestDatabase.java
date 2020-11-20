/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatbot.application.database;

/**
 *
 * @author dharma
 */
public class TestDatabase {
    public static void main(String[] args) {
        Answer answer = new Answer().getByKeyword("Hai");
        
        System.out.println(answer.getAnswer());
    }
}
