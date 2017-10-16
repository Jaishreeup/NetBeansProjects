/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author jaishree
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection c;
            ResultSet rs;
            Statement s;
        try {
            // printWriter out=new getWriter();
            
            System.out.println("k");
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("yup");
c=DriverManager.getConnection("jdbc:derby://localhost:1527/exampleshan","shan","shan");
             //lass.forName("org.apache.derby.jdbc.EmbeddedDriver");
                   
               System.out.println("sdfds");
              
               
               
            s=c.createStatement();
            String sql="select * from UNTITLED";
            rs=s.executeQuery(sql);
            while(rs.next())
            {
                System.out.println("hi "+rs.getString("name"));
                System.out.println("your age is:"+rs.getString("age"));
            }
            c.close();
            // TODO code application logic here
        }
         catch (SQLException ex) {
             System.out.println("In  found");
  //          Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
         }
 catch (ClassNotFoundException ex) {
           System.out.println("class not found");
        }
        
    }
}    

