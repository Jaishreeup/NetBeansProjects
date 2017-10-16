package erp;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.*;
/*<applet code="signup.class" width=300 height=500>
 * </applet>
 */
public class changepass extends JApplet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel p=new JPanel();
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5;
	JPasswordField p1,p2,p3,p4;
	String s="ad";
	public changepass()
	{
		
	}
	public changepass(String id)
	{
		s=id;
	}
	public void init()
	{
	    p.setLayout(null);
		p.setBackground(Color.white);
		p.setBorder( new TitledBorder ( new EtchedBorder (), "CHANGING PASSWORD" ) );
		l1=new JLabel("Current Password:");
		l2=new JLabel("New Password:");
		l3=new JLabel("Confirm New Password:");
		l4=new JLabel("(Click  Submit to Change Password)");
		l5=new JLabel("(Click Cancel to exit)");
		p1=new JPasswordField(30);
		p2=new JPasswordField(30);
		p3=new JPasswordField(30);
		l1.setBounds(60,30,200,30);
		l2.setBounds(60,80,200,30);
		l3.setBounds(60,130,200,30);
		p1.setBounds(250,30,200,30);
		p2.setBounds(250,80,200,30);
		p3.setBounds(250,130,200,30);
		l4.setBounds(240,200,300,30);
		l5.setBounds(285,220,300,30);
		b1=new JButton("Submit");
		b1.setBounds(250,170,80,30);
		b2=new JButton("Cancel");
		b2.setBounds(350,170,80,30);
		add(p);
		p.add(l1);
		p.add(p1);
		p.add(l2);
		p.add(p2);
		p.add(l3);
		p.add(p3);
		p.add(b1);
		p.add(l4);
		p.add(b2);
		p.add(l5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(500,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		char cp[]=p1.getPassword();
		String s1,s2,s3;
		s1=new String(cp);
		char np[]=p2.getPassword();
		s2=new String(np);
		char rp[]=p3.getPassword();
		s3=new String(rp);
		if(e.getSource()==b1)
		{
			if(s1.length()==0 || s2.length()==0 || s3.length()==0)
			{
				JOptionPane.showMessageDialog( null, "Please fill in all values", "Error in Changing Current Password", JOptionPane.ERROR_MESSAGE);
			}
			else
			{	
				if(!s1.equals(s))
				{
					JOptionPane.showMessageDialog( null, "Entered Password Do not Match With Current Password", "Error in Changing Current Password", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(!s2.equals(s3))
					{
						JOptionPane.showMessageDialog( null, "Entered Passwords Do not Match", "Error in Changing Current Password", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog( null, "Password Change Successful");
						System.exit(0);
					}
				}
			}
		}
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
	}
}