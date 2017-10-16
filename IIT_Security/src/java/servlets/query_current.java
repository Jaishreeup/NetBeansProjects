/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import static servlets.errant.s;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "query", urlPatterns = {"/query"})
public class query_current extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static Connection c;
    static Statement s;
    static ResultSet rs; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      response.setContentType("text/html;charset=UTF-8");
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
     int sum=0;
     int count=0;
       try (PrintWriter out = response.getWriter()) {
       
        try{   
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
         s=c.createStatement();
           /* TODO output your page here. You may use following sample code. */
            
//                RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
//                rd.include(request, response);
//                out.print("Registration successful! Please Login. ");
//             //show pop up
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/pass.html");
            rd.include(request, response);
            
         String sql="SELECT * FROM vehicles t1 LEFT JOIN IN_OUT_LOG t2 ON t2.regno = t1.reg_no and t2.model=t1.model WHERE t2.regno IS NULL";
         rs=s.executeQuery(sql);
         out.print("<center><br><br>");
             out.print("<p align='center'><Table border='1'>");
             out.print("<tr><th> REG NO</TH>");
             out.print("<th> MODEL</TH>");
             out.print("<th> TYPE</TH></tr>");
         while(rs.next())
         {
             out.print("<tr><td>"+rs.getString(1)+"</td>");
             out.print("<td>"+rs.getString(2)+"</td>");
             out.print("<td>"+"inside"+"</td>");
         count++;
         }
//         sum+=rs.getInt(1);
  //          System.out.println("sum= "+sum);
         sql="select * from IN_OUT_LOG where type='out'";
         rs=s.executeQuery(sql);
          while(rs.next())
         {
             out.print("<tr><td>"+rs.getString(1)+"</td>");
             out.print("<td>"+rs.getString(2)+"</td>");
             out.print("<td>"+"outside"+"</td></tr>");
         count++;
         }

            System.out.println("sum "+count);
// sql="select"
         }catch(Exception e)
         {
             e.printStackTrace();
         }
            out.println("Number of vehicles currently inside the campus: "+count);  
            
            
        }    }

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
