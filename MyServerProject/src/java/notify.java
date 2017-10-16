

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.swing.UIManager.get;

@WebServlet(name = "notify", urlPatterns = {"/notify"})
public class notify extends HttpServlet {
Connection c;
Statement s;
ResultSet rs;
String temp="";
static String newDate="20-08-2015",oldDate="20-08-2015";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //    response.setContentType("text/html;charset=UTF-8");
response.setContentType("application/json");//setting content type as json
              
  try(PrintWriter out1 = response.getWriter()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            newDate=dateFormat.format(cal.getTime());
            String str="DELETE FROM 2012BCS2211_NOTIFICATION WHERE DATE<'"+newDate+"'";  
            String jo="{\"results\":[";				//string jo strores the json result
            Class.forName("com.mysql.jdbc.Driver");
    //      c=DriverManager.getConnection("jdbc:mysql://166.62.8.12/abescs","abescs","Abesec@0");
 //            c=DriverManager.getConnection("jdbc:mysql://117.55.241.6/localhost/test","test","test@321");
           c=DriverManager.getConnection("jdbc:mysql://50.62.209.148:3306/abesec_Notifier","Notifier","Qip?w666");
  
            String sql="select * from 2012BCS2211_NOTIFICATION ORDER BY ID DESC";
            s=c.createStatement();
            String default1="[\"a\",\"2015-01-01\",\"a\",\"a\",\"-1\",\"aaaaa\",\"a\"]";  //default value for json
            if(!oldDate.equals(newDate))
            {
             
                 System.out.println(s.executeUpdate(str));
                 System.out.println("hi "+dateFormat.format(cal.getTime()));
                 oldDate=newDate;
            }
             rs=s.executeQuery(sql);
               System.out.println("i m here");
              while(rs.next())  //going to store data in json string in json format and replace (") with actual (\")
             {
                 jo+="[\""+rs.getString("EVENT").replace("\"","\\\"")
                         +"\",\""+rs.getString("DATE").replace("\"","\\\"")+"\",\""+rs.getString("INFO").replace("\"","\\\"")
                         +"\",\""+rs.getString("ISSUER").replace("\"","\\\"")+"\",\""+rs.getString("ID").replace("\"","\\\"")
                         +"\",\""+rs.getString("PREF").replace("\"","\\\"")+"\",\""+rs.getString("FILENAME").replace("\"","\\\"")+"\"],";
             }
             jo+=default1;
             jo=jo.substring(0,jo.length()-1);
             jo+="]}";
             System.out.println(jo); //printing o/p on screen
             out1.print(jo);		//writing o/p to o/p stream which is sent to the app as json
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(fetchNotification.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
       // Logger.getLogger(fetchNotification.class.getName()).log(Level.SEVERE, null, ex);
    ex.printStackTrace();
        }
        }
 
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

