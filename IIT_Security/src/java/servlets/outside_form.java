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
@WebServlet(name = "outside_form", urlPatterns = {"/outside_form"})
public class outside_form extends HttpServlet {
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

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
                    try {                                              
                
                // TODO add your handling code here:
                s=c.createStatement();
                String sql="insert into outside values('"+request.getParameter("username")+"','"+request.getSession().getAttribute("model")+"','"+request.getSession().getAttribute("reg")+"','"+request.getParameter("purpose")+"',"+request.getParameter("contact")+")";                
                System.out.println(""+sql);   
                s.executeUpdate(sql);
                        sql="insert into IN_OUT_LOG values('"+request.getSession().getAttribute("reg")+"','"+request.getSession().getAttribute("model")+"','"+request.getSession().getAttribute("t1")+"','00:00:00','"+request.getSession().getAttribute("t0")+"','0002-11-30','out','no','null')";
                        System.out.println(sql);
                        s=c.createStatement();
                        s.executeUpdate(sql);

                RequestDispatcher rd=getServletContext().getRequestDispatcher("/camera.html");
                    rd.forward(request, response);

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }


        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet outside_form</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet outside_form at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
               Logger.getLogger(outside_form.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(outside_form.class.getName()).log(Level.SEVERE, null, ex);
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
               Logger.getLogger(outside_form.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(outside_form.class.getName()).log(Level.SEVERE, null, ex);
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
