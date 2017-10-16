package example;
//import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/*<applet code=check width=300 height=300>
</applet>
*/
public class check extends Applet
{
 public void init(){
Checkbox ch=new Checkbox();
ch.setLabel("male");
Checkbox ch1=new Checkbox();
ch1.setLabel("female");
add(ch);
add(ch1);   
//check c=new check();
}
  public check() throws InstantiationException, IllegalAccessException
 {
     Connection c;
            ResultSet rs;
            Statement s;
        try {
            // printWriter out=new getWriter();
            
            System.out.println("k");
            //Class cl=org.apache.derby.jdbc.EmbeddedDriver.class;
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            System.out.println("yup");
c=DriverManager.getConnection("jdbc:derby://localhost:1527/exampleshan","shan","shan");
             //lass.forName("org.apache.derby.jdbc.EmbeddedDriver");
                   
            System.out.println("sdfds");
                     
            s=c.createStatement();
            String sql="select * from UNTITLED";
            rs=s.executeQuery(sql);
            while(rs.next())
            {
                System.out.println("hi "+rs.getString("name"));
                System.out.println("your age is:"+rs.getString("age"));
            }
            
            // TODO code application logic here
        }
         catch (SQLException ex) {
             System.out.println("In  found");
           Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
         }
 catch (ClassNotFoundException ex) {
        System.out.println("class not found");
 }
   
 }
}