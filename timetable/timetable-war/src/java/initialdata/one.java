package initialdata;
import java.awt.*;
import javax.swing.*;
class one 
{
    public static void main(String args[])
    {
        JFrame frame= new JFrame("timetable");
            
            frame.setDefaultCloseOperation (
                    javax.swing.WindowConstants.EXIT_ON_CLOSE
            );
        Font font = new Font(null,Font.BOLD,30);
	Font font1 = new Font(null,Font.ITALIC,20);
        JLabel l1=new JLabel("WELCOME USER...");
        JLabel l2=new JLabel("TIMETABLE GENERATION SOFTWARE");
        //JLabel l3=new JLabel("GENERATE NEW TIMETABLE ");
        //JLabel l4=new JLabel("VIEW TIMETABLE");
        JButton generate=new JButton("GENERATE NEW TIMETABLE ");
        JButton view=new JButton("VIEW TIMETABLE ");
        Container cp = frame.getContentPane();
        cp.setLayout(null);
        l1.setFont(font1);
        l2.setFont(font);
        l1.setBounds(70,30,400,100);
        l2.setBounds(120,100,600,200);
        generate.setBounds(150,300,200,50);
        view.setBounds(420,300,200,50);
        cp.add(l1);
        cp.add(l2);
        cp.add(generate);
        cp.add(view);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBounds(10, 10, 800, 500 );
        frame.setVisible(true);
              
    }
}