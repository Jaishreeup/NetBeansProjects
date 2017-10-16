package erppack;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login  extends JFrame implements ActionListener
{
	JButton b;
	Font font;
	JLabel L;
	
	Login(String s)
	{
		b = new JButton("LOG OUT");
		font = new Font("Courier",Font.BOLD,26);
		L = new JLabel("NAME: " +s);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LOGGED IN");
		setSize(1300,700);
		b.setBounds(1100,100,100,30);
		L.setBounds(100,200,1000,30);
		L.setFont(font);
		L.setForeground(Color.blue);
		add(L);
		add(b);
		b.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			try 
			{
				ERP r = new ERP();
				setVisible(false);
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
		}
		
	}
	public static void main(String a[])
	{
		Login S = new Login("shanu");
		
	}

}
