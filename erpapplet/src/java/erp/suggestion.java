package erp;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.*;
public class suggestion extends JApplet implements ActionListener
{
	JTextField 	username;
	JTextArea suggestion;
	JPasswordField pass;
	JLabel l1,l2,l3;
	JButton b1,b2;
	JPanel p;
	JScrollPane scroll;
	private static final long serialVersionUID = 1L;
	public void init()
	{
		pass=new JPasswordField(30);
		username=new JTextField(30);
		suggestion=new JTextArea(5,5);
		p=new JPanel();
		p.setLayout(null);
		p.setBorder( new TitledBorder ( new EtchedBorder (), "ANY SUGGESTIONS?" ) );
		username.setBounds(180,30,200,30);
		pass.setBounds(180,80,200,30);
		suggestion.setBounds(180,130,200,100);
		l1=new JLabel("Username:");
		l1.setBounds(50,30,150,30);
		l2=new JLabel("Password:");
		l2.setBounds(50,80,150,30);
		l3=new JLabel("Suggestion:");
		l3.setBounds(50,150,100,30);
		b1=new JButton("SUBMIT");
		b1.setBounds(180,250,80,30);
		b2=new JButton("CANCEL");
		b2.setBounds(280,250,80,30);
		suggestion.setLineWrap(true);
		suggestion.setBorder(BorderFactory.createLineBorder(Color.gray));  
		suggestion.setWrapStyleWord(true);
		suggestion.setFocusable(true);
		scroll = new JScrollPane (suggestion);
		scroll.setBounds(180,130,200,100);
		setSize(500,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
	}
	public void paint(Graphics g)
	{
		add(p);
		p.add(b1);
		p.add(b2);
		p.add(scroll,BorderLayout.EAST);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(pass);
		p.add(username);
		p.add(suggestion);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
}
	