/*<applet code="signup" width=1350 height=650>
  </applet>*/
package erp;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import erp.temp;

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
		L1 = new JLabel("USERNAME:");
		L7 = new JLabel("FIRST NAME:");
		L8 = new JLabel("LAST NAME:");
		L9 = new JLabel("RETYPE EMAIL:");
		L10 = new JLabel(new ImageIcon("main.gif"));
		L10.setBounds(0,0,600,600);
		username = new JTextField(50);
		L2 = new JLabel("EMAIL:");
		m=new JButton("CANCEL");
		email = new JTextField(100);
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
		b1.setBounds(240,450,60,30);
		b2.setBounds(310,450,110,30);
		b1.setSelected(true);
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
        
             
		if(e.getSource()==B)
		{
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
                                    temp te=new temp();
                                    //  te.getResults();
					JOptionPane.showMessageDialog(P, "SIGNUP SUCCESSFUL");
					System.exit(0);
				}
			}
			
		}
		if(e.getSource()==m)
		{
			System.exit(0);
		}
	}
}