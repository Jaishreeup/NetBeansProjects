/*<applet code="signup" width=1350 height=650>
  </applet>*/
package example;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class signup extends JApplet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JTextField firstname,lastname,email,retypeemail,username;
	JPasswordField p1,p2;
	JRadioButton b1,b2;
	ButtonGroup b;
	JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10 ;
	Font font;
	JButton B,m;
	JPanel P,temp;
    	public void init()
	{
		P = new JPanel();
		P.setBorder( new TitledBorder ( new EtchedBorder (), "NEW MEMBER" ) );
		font = new Font(null,Font.BOLD,20);
		L6 = new JLabel("SIGNUP CREDENTIALS");
		L1 = new JLabel("USERNAME:");	//L1.setForeground(Color.red);
		L7 = new JLabel("FIRST NAME:");
		L8 = new JLabel("LAST NAME:");
		L9 = new JLabel("RETYPE EMAIL:");
		L10 = new JLabel(new ImageIcon("1.jpg"));
		L10.setBounds(0,0,600,600);
		username = new JTextField(50);
		username.setOpaque(false);
		L2 = new JLabel("EMAIL:");
		m=new JButton("CANCEL");
		email = new JTextField(100);
		email.setBackground(null);
		retypeemail=new JTextField(100);
		firstname=new JTextField(100);
		lastname=new JTextField(100);
		L3 = new JLabel("PASSWORD:");
		p1 = new JPasswordField(50);
		L4 = new JLabel("CONFIRM PASSWORD:");
		p2 = new JPasswordField(50);
		L5 = new JLabel("GENDER:");
		b1 = new JRadioButton("MALE");
		b2 = new JRadioButton("FEMALE");
		b = new ButtonGroup();
		B = new JButton("SIGN UP");
		
		setSize(600,600);
		P.setLayout(null);
		L6.setFont(font);
		L6.setBounds(200, 40, 300, 30);
		L6.setForeground(Color.BLUE);
		b1.setBounds(240,455,60,18);
		b1.setOpaque(false);
		b2.setBounds(310,455,70,18);
		b1.setSelected(true);
		b2.setOpaque(false);
		L7.setBounds(100,100,100,30);
		firstname.setBounds(240,100,200,30);
		L8.setBounds(100,150,100,30);
		lastname.setBounds(240,150,200,30);
		username.setBounds(240,200,200,30);
		L1.setBounds(100,200,100,30);
		L3.setBounds(100,350,100,30);
		p1.setBounds(240,350,200,30);
		L2.setBounds(100,250,100,30);
		L4.setBounds(100,400,150,30);
		p2.setBounds(240,400,200,30);
		L5.setBounds(100,450,100,30);
		B.setBounds(200,500,100,30);
		m.setBounds(320,500,100,30);
		email.setBounds(240,250,200,30);
		L9.setBounds(100,300,200,30);
		retypeemail.setBounds(240,300,200,30);
		add(P);
		b.add(b1);
		b.add(b2);
		P.add(L6);
		P.add(b1);
		P.add(b2);
		P.add(L7);
		P.add(firstname);
		P.add(L8);
		P.add(lastname);
		P.add(L3);
		P.add(L1);
		P.add(username);
		P.add(L2);
		P.add(m);
		P.add(email);
		P.add(L9);
		P.add(retypeemail);
		P.add(p1);
		P.add(L4);
		P.add(p2);
		P.add(L5);
		P.add(B);
		P.add(L10);
		B.addActionListener(this);
		m.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String T1 = firstname.getText();
		String T2 = lastname.getText();
		String T3 = username.getText();
		String T4 = email.getText();
		String T5 = retypeemail.getText();
		String t="";
		char[] s1 = p1.getPassword();
		char[] s2 = p2.getPassword();
		String s3 = new String(s1);
		String s4 = new String(s2); 
		if(e.getSource()==B)
		{
                    try {
                        if(T1.equals(t) || T2.equals(t) || s3.equals(t) || s4.equals(t) || T3.equals(t) || T4.equals(t) || T5.equals(t))
                        {
                            System.out.println(T1+T2+T3+T4+T5+s3+s4);
                            JOptionPane.showMessageDialog(P,"FILL ALL THE TABS!!");
                        }
                        else
                        {
                            if(T4.indexOf('@')==-1 || !s4.equals(s3) || !T4.equals(T5))
                            {
                                JOptionPane.showMessageDialog(P,"PASSWORD'S/EMAIL'S DON'T MATCH OR EMAIL IS INVALID!!");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(P, "SIGNUP SUCCESSFUL");
                           Connection c;
                           Statement s = null;
                           ResultSet rs;

                        System.out.println("Hello");
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                        System.out.println("hi");      
                        c=DriverManager.getConnection("jdbc:derby://localhost:1527/exampleshan","shan","shan");
                        System.out.println("yo");
                        String sql="insert into USERDETAILS values('"+T3+"','"+s3+"')";
                        System.out.println(sql);
                       // s.executeUpdate(sql);
                        PreparedStatement pst =c.prepareStatement(sql);
            int numRowsChanged = pst.executeUpdate();
             
                        System.out.println("Nahi");
                    } }} 
                        catch(SQLException ex)
                        {  System.out.println("exception");
		}   catch (ClassNotFoundException ex) {
                        Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                    }
		if(e.getSource()==m)
		{
			System.exit(0);
		}
	}
        }
}