package erp;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class CircleDraw extends JApplet implements MouseListener,MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	JTextField 	username;
	JPasswordField pass;
	JLabel l1,l2,l3;
	JButton b1;
	String msg;
	JPanel p;
	public void init()
	{
		pass=new JPasswordField(30);
		username=new JTextField(30);
		p=new JPanel();
		p.setLayout(null);
		p.setBorder( new TitledBorder ( new EtchedBorder (), "POST SECTION" ) );
		username.setBounds(180,30,200,30);
		pass.setBounds(180,80,200,30);
		l1=new JLabel("Username:");
		l1.setBounds(50,30,150,30);
		l2=new JLabel("Password:");
		l2.setBounds(50,80,150,30);
		l3= new JLabel(msg);
		l3.setBounds(100,200,200,100);
		b1=new JButton("SUBMIT");
		b1.setBounds(180,250,80,30);
		setSize(500,300);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		b1.addMouseListener(this);
		b1.addMouseMotionListener(this);
		add(p);
		p.add(b1);
		p.add(l1);
		p.add(l2);
		p.add(pass);
		p.add(username);
		p.add(l3);
		showStatus(msg);
	}
	public void mouseDragged(MouseEvent e) {
	msg="Mouse is Dragged";
	repaint();
	}
	public void mouseMoved(MouseEvent e) {
	msg="Mouse is Moved";
	repaint();
	}
	public void mouseClicked(MouseEvent arg0) {
		msg="Mouse is Clicked";
		repaint();
	}
	public void mouseEntered(MouseEvent arg0) {
		msg="Mouse is Entered";
		repaint();
	}
	public void mouseExited(MouseEvent arg0) {
		msg="Mouse is Exited";
		repaint();
	}
	public void mousePressed(MouseEvent arg0) {
		msg="Mouse is Pressed";
		repaint();
	}
	public void mouseReleased(MouseEvent arg0) {
		msg="Mouse is Released";
		repaint();
	}
}
