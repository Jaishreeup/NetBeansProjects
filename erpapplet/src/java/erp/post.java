package erp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
public class post extends JApplet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JTextField 	username;
	JTextArea post;
	JPasswordField pass;
	JLabel l1,l2,l3;
	JButton b1,b2;
	JPanel p;
	JScrollPane scroll;
	String pa;
	public void init()
	{
		pass=new JPasswordField(30);
		username=new JTextField(30);
		post=new JTextArea(5,5);
		p=new JPanel();
		p.setLayout(null);
		p.setBorder( new TitledBorder ( new EtchedBorder (), "POST SECTION" ) );
		username.setBounds(180,30,200,30);
		pass.setBounds(180,80,200,30);
		post.setBounds(180,130,200,100);
		l1=new JLabel("Username:");
		l1.setBounds(50,30,150,30);
		l2=new JLabel("Password:");
		l2.setBounds(50,80,150,30);
		l3=new JLabel("To Post:");
		l3.setBounds(50,150,100,30);
		b1=new JButton("SUBMIT");
		b1.setBounds(180,250,80,30);
		b2=new JButton("CANCEL");
		b2.setBounds(280,250,80,30);
		post.setLineWrap(true);
		post.setBorder(BorderFactory.createLineBorder(Color.gray));  
		post.setWrapStyleWord(true);
		post.setFocusable(true);
		scroll = new JScrollPane (post);
		scroll.setBounds(180,130,200,100);
		add(p);
		p.add(b1);
		p.add(b2);
		p.add(scroll,BorderLayout.EAST);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(pass);
		p.add(username);
		p.add(post);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(500,300);
		setVisible(true);
	}
	Connection c;
	Statement s;
	ResultSet rs;
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		if(e.getSource()==b1)
		{
			//String user=username.getText();
			char[] pas=pass.getPassword();
			String password = new String(pas);
			if(!(password.equals(pa)))
			{
				JOptionPane.showMessageDialog( null, "You Dont have Authorized Access to this Feature", "Error in Posting", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
