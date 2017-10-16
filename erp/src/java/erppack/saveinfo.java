/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erppack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaishree
 */
@WebServlet(name = "saveinfo", urlPatterns = {"/saveinfo"})
public class saveinfo extends HttpServlet {

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
            Connection c;
           // Statement s;
          // ResultSet rs;
           
          //  try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/employee");
            String sql ="insert into EMPLOYEE_MASTER values (?,?,?,?,?)";
  PreparedStatement pst =c.prepareStatement(sql);
            String name=request.getParameter("name");
            String add=request.getParameter("add");
            String age=request.getParameter("age");
            String des=request.getParameter("desig");
            String id=request.getParameter("id");
            
            
  pst.setString(1,name);
  pst.setString(2,add);
  pst.setString(3, age);
  pst.setString(4, des);
  pst.setString(5, id);
  int numRowsChanged = pst.executeUpdate();
            //s=c.createStatement();
            //rs=s.executeQuery("insert into EMPLOYEE_MASTER values("+name+","+add+","+age+","+des+","+id);
            /* TODO output your page here. You may use following sample code. */
           
                    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet saveinfo</title>");            
            out.println("</head>");
            out.println("<body bgcolor=green>");
            out.println("<h1>Servlet saveinfo at " + request.getContextPath() +numRowsChanged+ "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
                catch(ClassNotFoundException | NumberFormatException | SQLException e){
                System.out.println(e.getMessage());}
  
        }  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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