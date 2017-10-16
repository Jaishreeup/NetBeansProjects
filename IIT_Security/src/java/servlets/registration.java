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

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

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
    private static String name,pass;
    private String email;
    private ResultSet rs;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        response.setContentType("text/html;charset=UTF-8");
    
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
    
        try (PrintWriter out = response.getWriter()) {
        try {                                         
            // TODO add your handling code here:
            name=request.getParameter("username");
            pass=request.getParameter("password");
            email=request.getParameter("email");
            s=c.createStatement();
            
            String sql="select * from employees where empid='"+name+"' and email='"+email+"'";
            System.out.println(sql);
            rs=s.executeQuery(sql);
            if(rs.next())
            {
                System.out.println("hhhhhhhhhhhh");
                sql="select * from credentials where id='"+name+"'";
                s=c.createStatement();
                rs=s.executeQuery(sql);
                System.out.println("here");
                if(!rs.next())
                {
                sql="insert into credentials values('"+name+"','"+pass+"')";
                s=c.createStatement();
                    System.out.println("hello");
                s.executeUpdate(sql);
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
                rd.include(request, response);
                out.print("Registration successful! Please Login. ");
             
                }
                else
                {
                    System.out.println("uouououou");
                     RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.html");
                rd.include(request, response);
             out.print("EMPLOYEE ID ALREADY REGISTERED ");
                }
            }
            else
            {
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.html");
                rd.include(request, response);
             out.print("please enter valid credentials");
               
            }
        }
        catch(Exception e)
        {
            
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
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
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
