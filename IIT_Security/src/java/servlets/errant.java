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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "errant", urlPatterns = {"/errant"})
public class errant extends HttpServlet {
   private String model;
    private String reg;
   static Connection c;
    static Statement s;
    static ResultSet rs; 
    private static String name,pass;
 
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
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
        try (PrintWriter out = response.getWriter()) {

        try{   
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
        
            reg=request.getParameter("registration");
            model=request.getParameter("model");
            s=c.createStatement();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calobj = Calendar.getInstance();
            System.out.println(df.format(calobj.getTime()));
            String str[]=df.format(calobj.getTime()).split(" ");
     
            String sql="insert into errant_log values('"+reg+"','"+model+"','"+str[0]+"','"+str[1]+"','')";
            s=c.createStatement();
            s.executeUpdate(sql);
                    sql="select * from vehicles where reg_no='"+reg+"' and model='"+model+"'";
            System.out.println(sql);
            rs=s.executeQuery(sql);
            if(rs.next())
            {
                System.out.println("mail sending");
                new SendMailBySite().main(new String[]{reg,model,rs.getString(1),rs.getString(3)});
                //javamail to dean
            }
            else
            {
            sql="update IN_OUT_LOG set errant='yes' where regno='"+reg+"' and model='"+model+"'";
             s=c.createStatement();
            s.executeUpdate(sql);
            }
            
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/errant.html");
                rd.include(request, response);
                out.print("details stored successfully");
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
