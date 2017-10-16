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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
       response.setDateHeader("Expires", 0); // Proxies.
     
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
                try {                                         
            // TODO add your handling code here:
            name=request.getParameter("username");
            pass=request.getParameter("password");
            request.getSession().setAttribute("user",name);
            s=c.createStatement();
             System.out.println("hkk "+name);
           String sql="select * from credentials where id='"+name+"' and pass='"+pass+"'";
            rs=s.executeQuery(sql);
            if(rs.next()){
                System.out.println("login successful...");
                  HttpSession session1=request.getSession();
                    session1.setAttribute("name",name);
                RequestDispatcher rd;
                if(name.contains("OF"))
                 rd=getServletContext().getRequestDispatcher("/officer_mainpage.html");
                else
                 rd=getServletContext().getRequestDispatcher("/gaurd_mainpage.html");
                    
            rd.forward(request, response);
  
              }
            else 
            {
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
                rd.include(request, response);
                out.print(" Incorrect Username or Password!! Please try again!!");
             
                System.out.println("login failed...");
            }
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
