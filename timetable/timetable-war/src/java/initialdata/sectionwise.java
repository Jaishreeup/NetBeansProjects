package initialdata;
import static initialdata.inserttofaculty.c;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
class sectionwise implements ActionListener
{
    static Connection c,c1;
    static Statement s,s1;
    static ResultSet rs,res;
    static String sql="";
    JComboBox d, f, g,section;
    JFrame frame;
    Container cp;
    Font font;
    Font font1;
    JLabel l1,l2,l3,l4,l5;
    JButton b;
    String departments[]=new String[40];
     String temp="",temp1,temp2;
    public  void ma() 
    {
        try {
            frame= new JFrame("timetable");
            cp = frame.getContentPane();
            cp.setLayout(null);
            frame.setDefaultCloseOperation (javax.swing.WindowConstants.EXIT_ON_CLOSE);
            font = new Font(null,Font.BOLD,20);
            font1=new Font(null,Font.ITALIC,20);
            l2 =new JLabel("DEPARTMENT  :");
            l3=new JLabel("YEAR                :");
            l1=new JLabel("COURSE           :");
            l4=new JLabel("SECTION          :");
            b=new JButton("SUBMIT");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/timetable","shantanu","jaishree");
            s = c.createStatement();
            String course[]={"select","BTECH"};
            g=new JComboBox(course);
            f=new JComboBox();        
            d=new JComboBox();
            section=new JComboBox();
            
            g.addActionListener(this);
           // d.addActionListener(this);
            //f.addActionListener(this);
            
            l1.setFont(font);            l2.setFont(font);           l3.setFont(font);
            l4.setFont(font);
            
            l2.setBounds(100,80,200,80);            d.setBounds(300,110,200,30);            f.setBounds(300,160,200,30);
            b.setBounds(210,270,100,30);            l3.setBounds(100,130,200,80);           l1.setBounds(100,30,200,80);
            g.setBounds(300,60,200,30);             l4.setBounds(100,180,200,80);           section.setBounds(300,210,200,30); 
            
            cp.add(d);            cp.add(f);            cp.add(l1);            cp.add(l2);            
            cp.add(b);            cp.add(l3);           cp.add(g);             cp.add(l4);
            cp.add(section);
            
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(facultywise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(facultywise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void actionPerformed(ActionEvent e) {
                    sql="";
                   
                    int a=0;
                    if(e.getSource()==g)
                    {
                        try {
                        int k=g.getSelectedIndex();
                        temp=(String)g.getSelectedItem();
                        System.out.println(k+"  "+temp);
                        cp.remove(d);
                        d=new JComboBox();
                        
                           String st="select";
                            d.insertItemAt(st,0);
                            d.setSelectedIndex(0);
                        
                        sql+= "select duration from course where name='"+temp+"'";
                        System.out.println("hiiii");
  
                        rs=s.executeQuery(sql);
                            int i=0;
                            int duration = 0;
                            while(rs.next())
                             {
                                duration=rs.getInt("duration");
                                System.out.println(duration);
                             }
                            sql="";    
                            sql+= "select name from "+temp;
                            rs=s.executeQuery(sql);
                            System.out.println("yoooo");   
                            while(rs.next())
                               {  departments[i++]=rs.getString(1);
                                    d.insertItemAt(departments[i-1], i);
                                    System.out.println(departments[i-1]);
                                }
                           
                        cp.remove(f);
                        f=new JComboBox();
                        f.insertItemAt(st,0);
                        f.setSelectedIndex(0);
                        
                        System.out.println("yup");
                        for(  i=1;i<=duration;i++)
                            f.insertItemAt(i,i);
                        System.out.println("iiii");
                        
                        f.addActionListener(this);
                        d.addActionListener(this);
                        f.setBounds(300,160,200,30);
                        d.setBounds(300,110,200,30); 
                        cp.add(f);
                         cp.add(d);
                    }   catch (SQLException ex) {
                        Logger.getLogger(facultywise.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                        if(e.getSource()==f)
                        {
                            System.out.println("thissssss!!1");
                        try {
                           a=(int)f.getSelectedItem();
                            temp2=(String)d.getSelectedItem();
                            System.out.println(" "+a+"   "+temp2+"   "+temp);
                            sql="";    
                            sql+= "select y"+a+" from "+temp+" where name='"+temp2+"'";
                           System.out.println(sql);
                            rs=s.executeQuery(sql);
                            System.out.println("yoooo");
                            cp.remove(section);
                        section=new JComboBox();
                        
                           String st="select";
                            section.insertItemAt(st,0);
                            section.setSelectedIndex(0);
                            int i=0;
                            int section_num=0;
                            String item[]={"A","B","C","D","E","F"};
                            while(rs.next())
                            {
                                section_num=rs.getInt(1);
                            }
                            for(  i=0;i<section_num;i++)
                                section.insertItemAt(item[i],i+1);
                        section.setBounds(300,210,200,30);
                        cp.add(section);
                       
                        } catch (SQLException ex) {
                            Logger.getLogger(sectionwise.class.getName()).log(Level.SEVERE, null, ex);
                        }
   
                        }
                    
        }
    public static void main(String args[])
    {
        sectionwise obj=new sectionwise();
        obj.ma();
    }
        
    }

