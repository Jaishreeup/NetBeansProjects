package initialdata;
import java.awt.*;
import javax.swing.*;
class two 
{
    public static void main(String args[])
    {
        JFrame frame= new JFrame("view timetable");
            
            frame.setDefaultCloseOperation (
                    javax.swing.WindowConstants.EXIT_ON_CLOSE
            );
        Font font = new Font(null,Font.BOLD,20);
	Font font1 = new Font(null,Font.ITALIC,20);
        JLabel l1=new JLabel("WHICH TIME TABLE WOULD YOU LIKE TO VIEW?");
        //JLabel l2=new JLabel("TIMETABLE GENERATION SOFTWARE");
        //JLabel l3=new JLabel("GENERATE NEW TIMETABLE ");
        //JLabel l4=new JLabel("VIEW TIMETABLE");
        JButton faculty=new JButton("FACULTY-WISE TIMETABLE");
        JButton section=new JButton("SECTION-WISE TIMETABLE");
        JButton lab=new JButton("LAB-WISE TIMETABLE");
        Container cp = frame.getContentPane();
        cp.setLayout(null);
        cp.add(l1);
        cp.add(faculty);
        cp.add(section);
        cp.add(lab);
        l1.setFont(font);
        l1.setBounds(160,40,500,100);
        faculty.setBounds(300,160,200,40);
        section.setBounds(300,210,200,40);
        lab.setBounds(300,260,200,40);
        frame.setBounds(10, 10, 800, 500 ); 
        frame.setVisible(true);
        
    }
}