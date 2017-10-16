package erppack;
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
public class ERP extends JFrame implements ActionListener,MouseListener
{
	final JFrame F= new JFrame("Main Page");
	JPanel P,P1;
	JButton B,B1;
	Font font,font1;
	JLabel L1,L2,L3,L5,L7,L8,l,l1,l2,L9,L6,l3,l4,L4;
	JLabel B2,B3,B4,B5,B6,B7,B8;
	JTextField T;
	JPasswordField T2,T1,T3;
         Connection c;
               Statement stmt;
               ResultSet rs;

	ERP() 
	{
		
		P = new JPanel();
		//P1 = new JPanel();
		L6 = new JLabel("<html>"
				+ "<body color=blue>"
				+ "<hr><br><br><br><br>"
				+ "<i><u>COPYRIGHT�  SHANTANU JAIN, SHANTANU AGARWAL AND JAISHREE UPRETY"
				+ "</body>"
				+ "</html>");
		L8 = new JLabel("<html>"
				+ "<b>"
				+ "<h1>RECENT DOINGS</h1>"
				+ "</b>"
				+ "<br><br><br><br>"
				+ "ACHIEVEMENTS"
				+ "</html>");
		L5 = new JLabel("<html><u><i>NEW MEMBER?</html>");
		B = new JButton("<html><body color=blue><i>SIGN UP</body></html>");
		B1 = new JButton("<html><body color=blue><i>LOG IN</body></html>");
		L3 = new JLabel("<html><u><i>EXISTING MEMBER</html>");
		L1 = new JLabel("USERNAME:");
		T = new JTextField();
		L2 = new JLabel("PASSWORD:");
		T2 = new JPasswordField();
		L4 = new JLabel("<html><b><u>(Recover password?)</html>");
		B2 = new JLabel("<html><body color=red><u><i>GALLERY</body></html>");
		B3 = new JLabel("<html><body color=red><u><i>LOCTAIONS</body></html>");
		B4 = new JLabel("<html><body color=RED><u><i>MEMBERS</body></html>");
		B5 = new JLabel("<html><body color=RED><u><i>FACILITIES</body></html>");
		B6 = new JLabel("<html><body color=RED><u><i>DONATION</body></html>");
		B7 = new JLabel("<html><body color=RED><u><i>APPLY ONLINE</body></html>");
		B8 = new JLabel("<html><body color=RED><u><i>ASK FOR HELP</body></html>");
		font = new Font(null,Font.BOLD,20);
		font1 = new Font(null,Font.ITALIC,28);
		L7 = new JLabel();
		l = new JLabel(new ImageIcon("D:\\Users\\JAIN\\Pictures\\abeslogo.png"));
		l1 = new JLabel(new ImageIcon("D:\\Users\\JAIN\\Pictures\\dlogo.png"));
		L9 = new JLabel("<html>"
				+ "<body color=RED>"
				+ "ISSUES REGARDING LOGIN?"
				+ "<br>"
				+ "CONTACT US<br>"
				+ "<table border=1>"
				+ "<tr>"
				+ "	<td>SHANTANU JAIN </td>"
				+ "<td>9971492469</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>SHANTANU AGARWAL</td>"
				+ "<td>9990910397</td>"
				+ "</tr>"
				+ "<tr>"
				+ "	<td>JAISHREE UPRETY </td>"
				+ "<td>9973765376</td>"
				+ "</tr>"
				+ "</table></body></html>");
		//l3 = new JLabel("PASSWORD:");  			 l3.setBounds(60,10,100,30);
		//T1= new JPasswordField(50);    			 T1.setBounds(200,10,180,30);
	//	l4 = new JLabel("CONFIRM PASSWORD:");     l4.setBounds(60,60,130,30);
	//	T3 = new JPasswordField(50);  			  T3.setBounds(200,60,180,30);
		P.setLayout(null);
	//	P1.setLayout(null);
		L6.setBounds(30,550,600,200);
		L8.setBounds(10,200,400,400);
		L8.setForeground(Color.red);
		l1.setBounds(1100,0,250,240);
		l.setBounds(0,0,220,280);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(1366,768);
		L3.setBounds(900,380,300,30);
		L3.setFont(font);
		L3.setForeground(Color.blue);
		L1.setBounds(840, 430,80, 30);
		T.setBounds(920, 430,170, 30);
		L2.setBounds(840, 480,80, 30);
		T2.setBounds(920, 480,170, 30);
		L5.setForeground(Color.blue);
		L5.setBounds(920, 260,160, 30);
		L5.setFont(font);
		B.setBounds(940, 290,100, 30);
		B1.setBounds(940, 520,100, 30);
		L4.setBounds(1100,480,160,30);
		L4.setForeground(Color.blue);
		B2.setBounds(1230, 290,60, 30);		
		B3.setBounds(1230, 340,70, 30);
		B4.setBounds(1230, 390,70, 30);
		B5.setBounds(1230, 440,80, 30);
		B6.setBounds(1230, 540,70, 30);
		B7.setBounds(1230, 590,90, 30);
		B8.setBounds(1230, 640,90, 30);
		L9.setBounds(850,500,300,300);
		//P1.setPreferredSize(new Dimension(500,100));
		F.add(P);
		//P1.add(l3);
		//P1.add(T1);
		//P1.add(Box.createHorizontalStrut(15));
		//P1.add(l4);
		//P1.add(T3);
		P.add(L6);
		P.add(L8);
		P.add(l1);
		P.add(l);
		P.add(L3);	
		P.add(L1);
		P.add(T);
		P.add(L2);
		P.add(T2);		
		P.add(B);
		P.add(L5);
		P.add(B1);
		P.add(L4);
		P.add(B2);
		P.add(B3);
		P.add(B4);
		P.add(B5);
		P.add(B6);
		P.add(B7);
		P.add(B8);
		P.add(L9);
	L4.addMouseListener(this);
	B2.addMouseListener(this);
	B3.addMouseListener(this);
	B4.addMouseListener(this);
	B5.addMouseListener(this);
	B6.addMouseListener(this);
	B7.addMouseListener(this);
	B8.addMouseListener(this);
	B.addActionListener(this);
	B1.addActionListener(this);
	F.setVisible(true);
	
	}
	

	public void showBanner() throws InterruptedException
	{
		
		String msg = "ENTERPRISE RESOURCE PLANNER FOR DELHI POLICE DEPT.     ";
		for(;;)
		{
			L7.setForeground(Color.red);
			L7.setFont(font1);
			L7.setBounds(220,100,900,30);
			L7.setText(msg);
			P.add(L7);
			Thread.sleep(130);
			char ch;
			ch=msg.charAt(0);
			msg=msg.substring(1,msg.length());
			msg+=ch;
		}
	}
	
	public  void actionPerformed(ActionEvent e)
	{
		
		String t1 = T.getText();
		String t2="";
		final String msg="LOGIN SUCCESFULL!";
		final String msg1="INVALID USERNAME OR PASSWORD!!";
		char[] s1 = T2.getPassword();
		String s2 = new String(s1); 
		if(e.getSource()==B1)
			
		{
			if(s2.equals(t2) || t1.equals(t2))
			{
				JOptionPane.showMessageDialog(P,"FILL ALL THE TABS");
			}
			else
			{
                             try{
                                 
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                   
               System.out.println("sdfds");
              
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/erpdata","jaishree","jaishree");
            System.out.println("after");
               
               
       System.out.println("xxx");
            String sql1="select * from SIGNUPDETAILS where username='"+t1+"' and password='"+s2+"'";
            stmt=c.createStatement();
            rs=stmt.executeQuery(sql1);
            if(rs.next())
                {
				
				JOptionPane.showMessageDialog(P,msg);
				int c=JOptionPane.showConfirmDialog(P, "DO YOU WISH TO CONTINUE?");
				if(c==JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
				else
				{
					if(c==JOptionPane.YES_OPTION)
					{
						
						Login  page = new Login(t1);
						F.setVisible(false);
					}
				}
         }
               else
            {
                JOptionPane.showMessageDialog(P,"INCORRECT USERNAME OR PASSWORD");
            }	
                             }
                                catch (SQLException ex) {
             System.out.println("In class not found");
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
         }
           catch (ClassNotFoundException ex) {
             System.out.println("In class not found");
             Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
          }
                        }
                }
		if(e.getSource()==B)
		{
			SignUp S = new SignUp();
		}
		
	}
        
	public void mouseClicked(MouseEvent e) 
	{
		
		if(e.getSource()==B2)
		{
			
		}
		if(e.getSource()==B3)
		{
		
		}
		if(e.getSource()==B4)
		{
		
		}
		if(e.getSource()==B5)
		{
		
		}
		if(e.getSource()==B6)
		{
		
		}
		if(e.getSource()==B7)
		{
		
		}
		if(e.getSource()==B8)
		{
			
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){} 

	public static void main(String arr[])
{
	try
	{
		ERP a = new ERP();
		a.showBanner();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}




