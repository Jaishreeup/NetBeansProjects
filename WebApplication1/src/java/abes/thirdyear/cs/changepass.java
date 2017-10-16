/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abes.thirdyear.cs;

import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
public class changepass extends JApplet implements ActionListener
{
	JPasswordField p1,p2,p3;
	JLabel l1,l2,l3,l4;
	JButton b1;
       //
	Panel p=new Panel();
	String s="Hello";
	/*public void start()
	{
	
	}*/
        @Override
        public void init()
	{
             //System.out.print("hi");
		p.setLayout(null);
                // System.out.print("\nh");
                 b1=new JButton("SUBMIT");
		l1=new JLabel("Old Password:");
		l2 =new JLabel("New Password:");
		l3=new JLabel("Confirm New Password:");
		l4=new JLabel("!!!Clicking on this will change your password!!!");
		p1=new JPasswordField(30);
		p2=new JPasswordField(30);
                // System.out.print("\ni");
		p3=new JPasswordField(30);
                 //System.out.print("\nhillo");
		l1.setBounds(60,30,200,30);
                 //System.out.print("\nhilllllll");
		l2.setBounds(60,80,200,30);
		l3.setBounds(60,130,200,30);
		p1.setBounds(250,30,200,30);
		
                p2.setBounds(250,80,200,30);
		
                p3.setBounds(250,130,200,30);
		
                l4.setBounds(150,210,300,30);
		
                b1.setBounds(250,170,80,30);
                 //System.out.print("\nyo");
		p.add(l1);
                 //System.out.print("yo");
		p.add(p1);
		p.add(l2);
		p.add(p2);
		p.add(l3);
		p.add(p3);
		p.add(b1);
		p.add(l4);
		centerFrame();
		add(p);
		b1.addActionListener(this);
		setSize(500,300);
		setVisible(true);
	}
	
	private void centerFrame()
	{
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - 250;
        int dy = centerPoint.y - 150;    
        setLocation(dx, dy);
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
					JOptionPane.showMessageDialog( null, "Entered Password Do Not Match With Current Password", "Error in Changing Current Password", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(!s2.equals(s3))
					{
						JOptionPane.showMessageDialog( null, "Entered Password Do Not Match", "Error in Changing Current Password", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog( null, "Password Changed Succesfully", "Current Password Changed!!!", JOptionPane.ERROR_MESSAGE);
						setVisible(false);
					}
				}
			}
		}
	}
	public void paint(Graphics g)
	{
		showStatus("Welcome Buddy To ERP");
	}
	private static final long serialVersionUID = 1L;
}
