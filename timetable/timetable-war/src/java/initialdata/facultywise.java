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
class facultywise implements ActionListener
{
    static Connection c;
    static Statement s;
    static ResultSet rs;
    static String sql="";
    JComboBox d, f, g;
    JFrame frame;
    Container cp;
    Font font;
    Font font1;
    JLabel l1,l2,l3;
    JButton b;
    String departments[]=new String[40];
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
            l3=new JLabel("FACULTY          :");
            l1=new JLabel("COURSE           :");
            b=new JButton("SUBMIT");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/timetable","shantanu","jaishree");
            s = c.createStatement();
            sql+= "select * from btech";
            rs=s.executeQuery(sql);
            int i=0;
                    while(rs.next())
                        {
                            departments[i++]=rs.getString(1);
                            System.out.println(departments[i-1]);
                        }
             
            String st="select";
            String course[]={"select","B.TECH"};
            g=new JComboBox(course);
            f=new JComboBox();        
            d=new JComboBox(departments);
            d.insertItemAt(st,0);
            d.setSelectedIndex(0);
            d.addActionListener(this);

            l1.setFont(font);            l2.setFont(font);           l3.setFont(font);
            
            l2.setBounds(100,80,200,80);            d.setBounds(300,110,200,30);            f.setBounds(300,160,200,30);
            b.setBounds(210,220,100,30);            l3.setBounds(100,130,200,80);           l1.setBounds(100,30,200,80);
            g.setBounds(300,60,200,30);
            
            cp.add(d);            cp.add(f);            cp.add(l1);            cp.add(l2);            
            cp.add(b);            cp.add(l3);           cp.add(g);
            
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
                    try {
                        String faculties[]=new String[100];
                        int k=d.getSelectedIndex();
                        String temp=(String)d.getSelectedItem();
                        System.out.println(k+"  "+temp);
                        cp.remove(f);
                        f=new JComboBox();
                        sql+= "select * from "+temp;
                        rs=s.executeQuery(sql);
                        int i=0;
                        f.insertItemAt("select",0);
                        f.setSelectedIndex(0);
                        while(rs.next())
                        {
                            faculties[i]=rs.getString(1);
                            f.insertItemAt(faculties[i],i+1);
                            i++;
                            //System.out.println(faculties[i-1]);
                        }
                        f.setBounds(300,160,200,30);
                        cp.add(f);
                        l2.setVisible(true);             
                    }   catch (SQLException ex) {
                        Logger.getLogger(facultywise.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
        }
    public static void main(String args[])
    {
        facultywise obj=new facultywise();
        obj.ma();
    }
        
    }

