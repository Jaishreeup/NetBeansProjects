/*<applet code="Test1.class" width = 1366 height = 728>
 * </applet>
 */
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
public class Test1 extends JApplet implements ActionListener,MouseListener 
{
     private static final long serialVersionUID = 1L;
     JLabel AndroidGIF;
     URL androidPath;
     public String msg="";
	TextArea t;
	JButton[] b = new JButton[5];
	JLabel[] j = new JLabel[5];
	int v[]=new int[5];
	int u=0;
	JPanel p;
	JTextField h;
	Graphics g=this.getGraphics();
	JLabel p1,p2,p3,p4,p5,c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	Font font1,statefont;
        
     public void init() 
    { 
         p=new JPanel();
        AndroidGIF = new JLabel();
        setLayout(null);
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		t = new TextArea(600,50);				t.setBounds(900,100,400,550);
		t.setForeground(Color.blue);    t.setVisible(false);
		h = new JTextField();		h.setBounds(900,70,400,30);
		h.setBorder(BorderFactory.createLineBorder(Color.blue));		h.setEditable(false);  
		l1 = new JLabel("SOLUTION TO DINING PHILOSOPHERS PROBLEM");		
		font1 = new Font("Comic Sans MS",Font.BOLD,32).deriveFont(fontAttributes);
		statefont = new Font("Comic Sans MS",Font.PLAIN,24);
		p.setLayout(null);		p.setBackground(Color.white);
		l1.setBounds(170,0,1000,50); 	l1.setFont(font1);		l1.setForeground(Color.RED);	l1.setBackground(null);
	
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       /* switch(i)
        {
            case 0: androidPath = this.getClass().getResource("1.gif");
                   break;
            case 1: androidPath = this.getClass().getResource("2.gif");
                   break;
            case 2: androidPath = this.getClass().getResource("3.gif");
                   break;
            case 3: androidPath = this.getClass().getResource("4.gif");
                   break;
            case 4: androidPath = this.getClass().getResource("5.gif");
                   
        }*/
                for(int i=0;i<5;i++)
		{
			b[i] = new JButton();				b[i].setBorderPainted(false);						b[i].setOpaque(false);
			b[i].setContentAreaFilled(false);	b[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			j[i] = new JLabel();
		}
                for(int i=0;i<5;i++)
		{
			j[i] = new JLabel("Thinking");		j[i].setFont(statefont);			j[i].setVisible(false);	
		}
		j[0].setBounds(434,70,150,35);			j[1].setBounds(655,193,150,35);		j[2].setBounds(580,450,150,35);	
		j[3].setBounds(45,450,150,35);			j[4].setBounds(14,160,150,35);	
		h.setForeground(Color.RED);
		
                c = new JLabel(new ImageIcon(this.getClass().getResource("4.png")));			c.setBounds(650,550,250,80);	c.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.addMouseListener(this);
		b[0].setBounds(330,150,100,100);		b[1].setBounds(580,293,100,100);	b[2].setBounds(497,530,100,100);		
		b[3].setBounds(185,530,100,100);		b[4].setBounds(100,289,100,100);
       /* AndroidGIF.setIcon(new ImageIcon(androidPath));
        GroupLayout layout = new GroupLayout(getContentPane());
        p.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
               // .addGap(27, 27, 27)
                .addComponent(AndroidGIF)
                //.addContainerGap(41, Short.MAX_VALUE)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                //.addGap(32, 32, 32)
                .addComponent(AndroidGIF)
                //.addContainerGap(46, Short.MAX_VALUE)
            )
        );

        pack();*/
                l2 = new JLabel(new ImageIcon(this.getClass().getResource("dine.png")));		l2.setBounds(0,90,1000,600);
	//	l3 = new JLabel(new ImageIcon(this.getClass().getResource("1.gif")));			l3.setBounds(90,90,600,600);		l3.setVisible(false);
	//	l4 = new JLabel(new ImageIcon(this.getClass().getResource("1.gif")));			l4.setBounds(90,90,600,600);		l4.setVisible(false);
	//	l5 = new JLabel(new ImageIcon(this.getClass().getResource("1.gif")));			l5.setBounds(90,90,600,600);		l5.setVisible(false);
	//	l6 = new JLabel(new ImageIcon(this.getClass().getResource("2.gif")));			l6.setBounds(90,90,600,600);		l6.setVisible(false);
	//	l7 = new JLabel(new ImageIcon(this.getClass().getResource("2.gif")));			l7.setBounds(90,90,600,600);		l7.setVisible(false);

    add(p);
    p.add(b[0]);	p.add(b[1]);	p.add(b[2]);	p.add(b[3]);	p.add(b[4]);
    p.add(j[0]);	p.add(j[1]);	p.add(j[2]);	p.add(j[3]);	p.add(j[4]);
		//p.add(l7);		p.add(l5);		p.add(l6);		p.add(l4);		p.add(l3);
		p.add(c);
		p.add(l1);
		p.add(l2);
		p.add(h);
		t.setEditable(false);
		t.setFocusable(true);
		p.add(t);
		p.setSize(1366,658);
		p.setVisible(true);
		setSize(1366,658);
		setVisible(true);
	}
public void actionPerformed(ActionEvent e)
	{
		/*for(int i=0;i<5;i++)
		if(e.getSource()==b[i])
		{
			v[i]++;
			if(v[i]%2!=0 && state[i]!=2)
			{
				msg+="\nPHILOSOPHER "+ i+" IS HUNGRY";
				t.setText(msg);
				pickup(i);
			}
			else
			{
				putdown(i);
				t.setText(msg);
			}
		}*/
	}

	public void mouseClicked(MouseEvent arg0) 
	{
		
	}

	public void mouseEntered(MouseEvent arg0) 
	{
		setCursor(new Cursor(Cursor.HAND_CURSOR));	
	}

	public void mouseExited(MouseEvent arg0) 
	{
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent arg0) 
	{
		l3.setVisible(true);
		l4.setVisible(true);
		l5.setVisible(true);
		l6.setVisible(true);
		l7.setVisible(true);
		msg="All PHILOSOPHERS ARE THINKING.";
		c.setIcon(new ImageIcon("3.png"));
		h.setText(msg);
		t.setText(msg);		
		for(int i=0;i<5;i++)
		{
			state[i%N]=phil_state.thinking;
			j[i].setText("Thinking");
			v[i]=0;
		}
		if(u==0)
		{
			for(int i=0;i<5;i++)
			{
				j[i].setVisible(true);
				b[i].addActionListener(this);
			}
			u++;	
		}
	}

	public void mouseReleased(MouseEvent arg0) 
	{
		c.setIcon(new ImageIcon("4.png"));
		c.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
        
static final int N=5;
enum  phil_state{ thinking, hungry, eating};
phil_state state[]=new phil_state[N];
//condition self[]=new condition[N];
    void putdown(int i)
    {
        if(state[i%N]== phil_state.eating)
			{
				state[i%N]=phil_state.thinking;
                                j[i].setText("Thinking");
				msg+="\nPHILOSOPHER "+ i +" IS THINKING";
				h.setText("PHILOSOPHER "+ i+ " IS THINKING");
				test((i+1)%N);
                                test((i+N-1)%N);
        
			}
			else
			{
				msg+="\nPHILOSOPHER "+ i+ " DON'T HAVE STICKS";
				h.setText("PHILOSOPHER "+ i+ " DON'T HAVE STICKS");
			}
    
        
    }
    void pickup(int i)
    {
        state[i%N]=phil_state.hungry;
        test(i);
    }
    void test(int i)
    {
        if(state[(i+1)%N]!=phil_state.eating &&state[(i+N-1)%N]!=phil_state.eating &&state[i%N]==phil_state.hungry)
        {
            state[i%N]=phil_state.eating;
            msg+="\nPHILOSOPHER "+i+" IS EATING";
	    h.setText("PHILOSOPHER "+i+" IS EATING");
	    j[i].setText("Eating");
        }
        if(state[i%N]==phil_state.hungry)
			{			
				msg+="\nPHILOSOPHER "+i+" IS WAITING";
				h.setText("PHILOSOPHER "+i+" IS WAITING");
				j[i].setText("Waiting");
			}
			t.setText(msg);
    }
}/*
 void chlo()
 {
     for(int i=0;i<20;i++)
        {
            d.pickup(i);
            System.out.println("eating philosopher:"+(i%d.N));    
            GIFTest g=new GIFTest(i%d.N);
            g.setVisible(true);
            d.putdown(i);
           // g.setVisible(false);
        }
 }
         public static void main(String args[])
        {
            monitor d=new monitor();    
        d.init();
        d.chlo();
        }

}*/