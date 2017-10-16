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
import static servlets.registration.s;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "register_vehicle", urlPatterns = {"/register_vehicle"})
public class register_vehicle extends HttpServlet {
 private String type;
     static Connection c;
    static Statement s;
  
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

   Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
            try {                                              
                    String sql="delete from vehicles where reg_no='"+request.getParameter("registration")+"' and model='"+request.getParameter("model")+"'";
                    s=c.createStatement();
                    s.executeUpdate(sql);
               
    
                // TODO add your handling code here:
                type=(request.getParameter("student/staff")) ;//"staff":"student");
                s=c.createStatement();
                 sql="insert into vehicles values('"+request.getParameter("name")+"',"+request.getParameter("contact")
                        +",'"+type+"','"+request.getParameter("vehicle")
                        +"','"+request.getParameter("registration")+"','"+request.getParameter("model")+"','"+request.getParameter("department")+"')";
                
                System.out.println(""+sql);   
                if(s.executeUpdate(sql)>0)
                {
                    RequestDispatcher rd=getServletContext().getRequestDispatcher("/inside.html");
                rd.include(request, response);
                out.print("Vehicle successfully registered!! ");
             
                }
        
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }


        }
    }
    void onBackPressed()
    {
        
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
         Logger.getLogger(register_vehicle.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(register_vehicle.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(register_vehicle.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(register_vehicle.class.getName()).log(Level.SEVERE, null, ex);
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
