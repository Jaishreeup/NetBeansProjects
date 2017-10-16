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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
@WebServlet(name = "erpservlet", urlPatterns = {"/erpservlet"})
public class erpservlet extends HttpServlet {

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
            Statement s;
            
            ResultSet rs;
            try{
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                c=DriverManager.getConnection("jdbc:derby://localhost:1527/employee");
                s =c.createStatement();
              String st=request.getParameter("id");
              int t=Integer.parseInt(st);
              out.println("hi "+t);
                rs=s.executeQuery("select * from EMPLOYEE_MASTER where id1='"+t+"'" );
                out.println("<b><center>Employee Details</center></b><br><br>");
             ResultSetMetaData rsmd=rs.getMetaData();
      int colcount=rsmd.getColumnCount();
      out.println("<table align=center border=1 cellpadding=2>");
                out.println("<tr>");
      for(int j=1; j<=colcount; j++){
        out.println("<th>" + rsmd.getColumnLabel(j) + "</th>");
      }
      out.println("<tr>");
      while(rs.next()){
        out.println("<tr>");
        out.println("<td>" + rs.getString("emp_fname") + "</td>");
        out.println("<td>" + rs.getString("address") + "</td>");
        out.println("<td>" + rs.getString("age") + "</td>");
        out.println("<td>" + rs.getString("desig") + "</td>");
        out.println("<td>" + rs.getString("id1") + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
            //    s.executeUpdate();
            }
                catch(ClassNotFoundException | NumberFormatException | SQLException e){
                System.out.println(e.getMessage());}
                  
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

    private String getParameter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getParam(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
