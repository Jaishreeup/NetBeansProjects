package erp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ERP extends JApplet implements ActionListener
{
	Graphics g;
	MediaTracker tr;
	private static final long serialVersionUID = 1L;
	Image i1, i2, i3, i4;
	JTextField username;
	JPasswordField pass;
	JLabel l1, l2, l3, l4;
	JButton log, sig;
	JPanel p;
	banner obj;
	Font f = new Font("Arial", Font.BOLD, 24);
        @Override
	public void init()
	{
		p = new JPanel();
		p.setLayout(null);
		p.setBorder(new TitledBorder(new EtchedBorder(), "OUR ERP"));
		//obj = new banner();
		//obj.init();
		//obj.start();
		//obj.run();
		l1 = new JLabel("USERNAME:");
		l1.setBounds(600, 400, 100, 30);
		l2 = new JLabel("PASSWORD:");
		l2.setBounds(600, 450, 100, 30);
		l3 = new JLabel("EXISTING MEMBER");
		l3.setBounds(620, 350, 300, 30);
		l3.setFont(f);
		l3.setForeground(Color.RED);
		l4 = new JLabel("NEW MEMBER");
		l4.setBounds(650, 200, 300, 30);
		l4.setFont(f);
		l4.setForeground(Color.BLUE);
		username = new JTextField(50);
		username.setBounds(700, 400, 150, 30);
		pass = new JPasswordField(50);
		pass.setBounds(700, 450, 150, 30);
		log = new JButton("LOGIN");
		log.setBounds(700, 500, 80, 30);
		sig = new JButton("SIGN UP");
		sig.setBounds(700, 250, 80, 30);
		setSize(1350, 650);
		setVisible(true);
	}
	public void paint(Graphics g) 
	{
		p.add(username);
		p.add(pass);
		p.add(l3);
		p.add(log);
		p.add(sig);
		sig.addActionListener(this);
		p.add(l1);
		p.add(l2);
		p.add(l4);
		add(p);
	/*	tr = new MediaTracker(this);
		i1 = getImage(getCodeBase(), "logo.png");
		i2 = getImage(getCodeBase(), "jaishree.png");
		i3 = getImage(getCodeBase(), "shantanu.png");
		i4 = getImage(getCodeBase(), "shan.png");
		tr.addImage(i1, 0);
		tr.addImage(i2, 0);
		tr.addImage(i3, 0);
		tr.addImage(i4, 0);
		g.drawImage(i1, 0, 0, 200, 200, this);
		g.drawImage(i2, 1152, 300, 210, 200, this);
		g.drawImage(i3, 1030, 300, 200, 200, this);
		g.drawImage(i4, 920 , 300, 180, 200, this);
	*/}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == sig)
		{
			p.setVisible(false);
		}
	}
}
