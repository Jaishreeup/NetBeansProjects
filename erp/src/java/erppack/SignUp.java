package erppack;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUp extends JFrame implements ActionListener
{
			JTextField t1,t2;
			JPasswordField p1,p2;
			JRadioButton b1,b2;
			ButtonGroup b;
			JLabel L1,L2,L3,L4,L5,L6 ;
			Font font;
			JButton B;
			Panel P;
			final JFrame F = new JFrame("SIGN UP");;
                        Connection c;
               Statement stmt;
               ResultSet rs;
	SignUp()
	{
	
		P = new Panel();
		font = new Font(null,Font.BOLD,20);
		L6 = new JLabel("SIGNUP CREDENTIALS");
		L1 = new JLabel("USERNAME:");
		t1 = new JTextField(50);
		L2 = new JLabel("EMAIL:");
		t2 = new JTextField(100);
		L3 = new JLabel("PASSWORD:");
		p1 = new JPasswordField(50);
		L4 = new JLabel("CONFIRM PASSWORD:");
		p2 = new JPasswordField(50);
		L5 = new JLabel("GENDER:");
		b1 = new JRadioButton("MALE");
		b2 = new JRadioButton("FEMALE");
		b = new ButtonGroup();
		B = new JButton("SIGN UP");
		F.setSize(600,600);
		//F.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		P.setLayout(null);
		L6.setFont(font);
		L6.setBounds(200, 40, 300, 30);
		L6.setForeground(Color.blue);
		b1.setBounds(240,300,60,30);
		b2.setBounds(310,300,110,30);
		b1.setSelected(true);
		L1.setBounds(100,100,100,30);
		t1.setBounds(240,100,200,30);
		L2.setBounds(100,150,100,30);
		t2.setBounds(240,150,200,30);
		L3.setBounds(100,200,100,30);
		p1.setBounds(240,200,200,30);
		L4.setBounds(100,250,150,30);
		p2.setBounds(240,250,200,30);
		L5.setBounds(100,300,100,30);
		B.setBounds(240,350,100,30);
		F.add(P);
		b.add(b1);
		b.add(b2);
		P.add(L6);
		P.add(b1);
		P.add(b2);
		P.add(L1);
		P.add(t1);
		P.add(L2);
		P.add(t2);
		P.add(L3);
		P.add(p1);
		P.add(L4);
		P.add(p2);
		P.add(L5);
		P.add(B);
		F.setVisible(true);
	B.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String T1 = t1.getText();
		String T2 = t2.getText();
		String t4 = T2.toLowerCase();
		String t="";
		final String msg="LOGIN SUCCESFULL!";
		char[] s1 = p1.getPassword();
		char[] s2 = p2.getPassword();
		String s3 = new String(s1);
		String s4 = new String(s2);
		if(e.getSource()==B)
		{
			if(T1.equals(t) || T2.equals(t) || s3.equals(t) || s4.equals(t))
			{
				JOptionPane.showMessageDialog(P,"FILL ALL THE TABS!!");
			}
			else
			{
				if(T2.indexOf('@')==-1 || !s4.equals(s3))
				{
					JOptionPane.showMessageDialog(P,"PASSWORD DON'T MATCH OR EMAIL IS INVALID!!");
				}
				else
				{
                                     try
                {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                   
               System.out.println("sdfds");
              
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/erpdata","jaishree","jaishree");
            System.out.println("after");
            String sql1="insert into SIGNUPDETAILS values('"+T1+"','"+T2+"','"+s3+"')";
            PreparedStatement pst =c.prepareStatement(sql1);
            int numRowsChanged = pst.executeUpdate();
             
                }
                catch(SQLException ex){System.out.println(ex);} catch (ClassNotFoundException ex) {
                                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                                    }
	
					JOptionPane.showMessageDialog(P, "SIGNUP SUCCESSFUL");
					F.setVisible(false);
				}
			}
			
		}
		
	}
	public static void main(String a[])
	{
		SignUp S = new SignUp();
		
	}
	
	
}

