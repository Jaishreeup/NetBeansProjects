/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static servlets.errant.c;
import static servlets.query_current.rs;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "in_out_query", urlPatterns = {"/in_out_query"})
public class in_out_query extends HttpServlet {
    private Statement s;
    private ResultSet rs;
    private int count=0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     response.setContentType("text/html;charset=UTF-8");
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
     

        try (PrintWriter out = response.getWriter()) {
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
           s=c.createStatement();
           String start=request.getParameter("start");
           String end=request.getParameter("end");
           System.out.println("hello "+start+" "+end);
           // Converting to String again, using an alternative format
          
           Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(start);
            System.out.println("date is: "+date1);
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
            String startDateString2 = df2.format(date1);
                  RequestDispatcher rd=getServletContext().getRequestDispatcher("/pass.html");
            rd.include(request, response);

            //System.out.println("hihihih");

//            System.out.println("Date in format dd/MM/yyyy: " + startDateString2);
//    
//           Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(start);
           //Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(end);
            System.out.println("hi");
     //      System.out.println(date1+"   this is date "+date2);
           String sql="select * from history where type='in' and entrydate>='"+start+"' and exitdate<='"+end+"'";
           rs=s.executeQuery(sql);
           System.out.println(sql);
           out.print("<center><p align='center'><Table border='1'>");
           out.print("<tr><th> REG NO</TH>");
           out.print("<th> MODEL</TH>");
            out.print("<th> ENTRY TIME</TH>");
             out.print("<th> EXIT TIME</TH>");
             out.print("<th> ENTRY DATE</TH>");
             out.print("<th> EXIT DATE</TH>");
             out.print("<th> TYPE</TH></tr>");
          while(rs.next())
         {
             out.print("<tr><td>"+rs.getString(1)+"</td>");
             out.print("<td>"+rs.getString(2)+"</td>");
             out.print("<td>"+rs.getString(3)+"</td>");
             out.print("<td>"+rs.getString(4)+"</td>");
             out.print("<td>"+rs.getString(5)+"</td>");
             out.print("<td>"+rs.getString(6)+"</td>");
             out.print("<td>"+"inside"+"</td></tr>");
             count++;
         }
        out.println("<br><br>");
          
               out.println("<br> number of inside vehicles gone out: "+count);
               int sum=count;
           
           sql="select * from history where type='out' and entrydate>='"+start+"' and entrydate<='"+end+"'";
           s=c.createStatement();
           rs=s.executeQuery(sql);
               out.print("<center><p align='center'><Table border='1'>");
             out.print("<tr><th> REG NO</TH>");
             out.print("<th> MODEL</TH>");
             out.print("<th> ENTRY TIME</TH>");
             out.print("<th> EXIT TIME</TH>");
             out.print("<th> ENTRY DATE</TH>");
             out.print("<th> EXIT DATE</TH>");
             out.print("<th> TYPE</TH></tr>");
          while(rs.next())
         {
             out.print("<tr><td>"+rs.getString(1)+"</td>");
             out.print("<td>"+rs.getString(2)+"</td>");
             out.print("<td>"+rs.getString(3)+"</td>");
             out.print("<td>"+rs.getString(4)+"</td>");
             out.print("<td>"+rs.getString(5)+"</td>");
             out.print("<td>"+rs.getString(6)+"</td>");
             out.print("<td>"+"inside"+"</td></tr>");
         count++;
         }

               out.println("<br><br> number of outside vehicles which entered the campus: "+(count-sum));
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(in_out_query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(in_out_query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(in_out_query.class.getName()).log(Level.SEVERE, null, ex);
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
