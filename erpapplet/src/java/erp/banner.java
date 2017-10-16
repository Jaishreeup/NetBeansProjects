package erp;
import java.awt.*;
import javax.swing.*;
public class banner extends JApplet implements Runnable
{
	private static final long serialVersionUID = 1L;
	JLabel L7;
	JPanel p;
	Font font1;
	Thread t=null;
	String msg = "  WELCOME TO ENTERPRISE RESOURCE PLANNING.  ";
	public void init()
	{
		p = new JPanel();
		p.setLayout(null);
		L7 = new JLabel();
		font1 = new Font("Lucida Calligraphy",Font.BOLD,24);
		add(p);
		p.add(L7);
		setSize(1350,650);
		setVisible(true);
	}
	public void start()
	{
		t= new Thread(this);
		t.start();
	}
	public void run()
	{
		char ch;
		try
		{
			for(;;)
			{
				L7.setForeground(Color.RED);
				L7.setFont(font1);
				L7.setBounds(300,100,900,30);
				L7.setText(msg);
				Thread.sleep(170);
				ch = msg.charAt(0);
				msg=msg.substring(1,msg.length());
				msg+=ch;
			}
		}
		catch(InterruptedException e)
		{
			
		}
	}
}
