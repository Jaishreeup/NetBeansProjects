/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/store"} )
public class store extends HttpServlet {

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
         System.out.println("hello");
        Connection con;
        Statement s;
        ResultSet rs;
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
                   Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/hcl","hcl","hcl");
            String sql="insert into DATABASE values('"+request.getParameter("name")+"','"+request.getParameter("pass")+"')";
           // String sql="select password from DATABASE where name='"+request.getParameter("name")+"'";
            s=con.createStatement();
            s.executeUpdate(sql);
           
            request.getServletContext().setAttribute("FILES_DIR","C:\\serverfiles");
          File dir=new File((String) request.getServletContext().getAttribute("FILES_DIR")+File.separator+request.getParameter("name")); 
          dir.mkdir();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
            out.println("<title>Servlet store</title> <link rel=\"stylesheet\" type=\"text/css\" href=\"form.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("your credentials have been saved successfully!!");
            out.println("<br>");
            out.println("<center><a href=\"index.html\">click here</a> to log in.</center>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(store.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("problem");
        } catch (SQLException ex) {
            Logger.getLogger(store.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("sql prob");
         ServletContext ct = getServletContext();
                        RequestDispatcher rd =ct.getRequestDispatcher("/index.html");
                        out.println("<div><font color=red><center>the user name already exists. please choose another name</center></font></div>");
                        rd.include(request, response);
                       
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
