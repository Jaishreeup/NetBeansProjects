/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(urlPatterns = {"/login"})
public class logincheck extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
              Connection con;
        Statement s;
        ResultSet rs;
        
        try {
            String name=request.getParameter("name1");
            String pass=request.getParameter("pass1");
                   Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/hcl","hcl","hcl");
           String sql="select password from DATABASE where name='"+name+"'";
            s=con.createStatement();
            rs=s.executeQuery(sql);
            if(rs.next())
            {
                if(rs.getString(1).equals(pass))
                {
                    request.setAttribute("name1",name);
                        System.out.println("aaaya"+request.getAttribute("name1"));
                    if(name.equals("admin"))
                    {
                        ServletContext ct = getServletContext();
                        RequestDispatcher rd =ct.getRequestDispatcher("/admin.jsp");
                        rd.forward(request, response);
                        return;
                    }       
                    else
                    {
                        System.out.println("yoooo");
                        ServletContext ct = getServletContext();
                        RequestDispatcher rd =ct.getRequestDispatcher("/user.jsp");
                        rd.forward(request, response);
                        return;
                    }
                }       
                else 
                {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                    //PrintWriter out= response.getWriter();
                    out.println("<font color=red><center>Either user name or password is wrong.</center></font>");
                    rd.include(request, response);

                }
            }
            else
            {
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                  //  PrintWriter out= response.getWriter();
                    out.println("<font color=red><center>Either user name or password is wrong.<center></font>");
                    rd.include(request, response);
 }
            
        }
         catch (ClassNotFoundException ex) {
            System.out.println("problem");
        } catch (SQLException ex) {
           System.out.println("sql prob");
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
