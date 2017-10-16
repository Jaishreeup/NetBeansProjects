package erp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class temp{
 public temp(){ 
 try
                {
                Connection c;
               //Statement stmt;
               //ResultSet rs; 
                           Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
               System.out.println("sdfds");
              
//             c=DriverManager.getConnection("jdbc:derby://localhost:1527/signupinfo");
  //          System.out.println("after");
           // String sql1="insert into SIGNUP values('"+T1+"','"+T2+"','"+T3+"','"+T4+"','"+s3+"')";
           // PreparedStatement pst =c.prepareStatement(sql1);
            //int numRowsChanged = pst.executeUpdate();
             
                }
    //            catch(SQLException ex){System.out.println(ex);} 
            catch (ClassNotFoundException ex) {
                                        Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (InstantiationException ex) {
         Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
         Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
     }
	
 }
    
}