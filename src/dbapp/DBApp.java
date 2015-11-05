/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tazim
 */
public class DBApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*String url = "jdbc:mysql://localhost:3306/";       
        String dbName = "db1";
        String driver = "com.mysql.jdbc.Driver"; 
        String userName = "root"; 
        String password = "xxxx";*/
        
        String url = "jdbc:mysql://db4free.net/"; 
        String dbName = "mahbubdb"; 
        String driver = "com.mysql.jdbc.Driver"; 
        String userName = "mahbub";
        String password = "mahbub123";
        
        
        try { 
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            //System.out.println("connection Successful");
            
            Statement st = conn.createStatement(); 
            //ResultSet res = st.executeQuery("SELECT * FROM studentrecord");
            ResultSet res = st.executeQuery("SELECT * FROM books");
            //st.executeUpdate("insert into books values (1007, 'Braille Adaptation', 'Mahbub', 14.23, 7)");
            
            while (res.next()) { 
                //int id = res.getInt("student_id");
                int id = res.getInt("id");
                //String name = res.getString("stud_first_name") + " " + res.getString("stud_last_name");
                String name = res.getString("title") + " " + res.getString("author");
                System.out.println(id + "\t" + name);
            }            
            
            conn.close(); 
        } 
        catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
