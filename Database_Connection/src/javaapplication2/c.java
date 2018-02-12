package javaapplication2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaishree
 */
import java.sql.*;
public class c {
    
    Connection c;
	Statement s;
	ResultSet rs;
	String password;
	static String a;
        public void feedtodb()
	{
		try
        {
            System.out.println("hi");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/erp","shan","shan");                   
            String sql="select PASSWORD from USERDETAILS where FIRSTNAME='2012BCS2209'";//+adno+"'";
            s = c.createStatement();
            rs = s.executeQuery(sql); 
            rs.next();
			password = rs.getString("PASSWORD");
			System.out.println(password);
        }
		catch(ClassNotFoundException e)
		{
			e.printStackTrace(System.out);
			//return "";
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			//return "";
		}
		//return password;
	}
}
