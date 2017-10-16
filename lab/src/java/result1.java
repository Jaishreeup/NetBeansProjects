/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(urlPatterns = {"/result1"})
public class result1 extends HttpServlet {
String resp,pub,faculty,award,year,sql,phd,project,publication,query;
Connection c;
    Statement s;
    ResultSet rs;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           resp= request.getParameter("resp");
            award=request.getParameter("award");
            faculty=request.getParameter("fac");
            year=request.getParameter("year");
            phd=request.getParameter("phd");
            publication=request.getParameter("pub");
            project=request.getParameter("proj");
            sql=request.getParameter("sql");
            System.out.println("resp: "+resp);
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          c=DriverManager.getConnection("jdbc:derby://localhost:1527/faculty_data");
   
            if(!resp.equals(""))
            {
                query="select NAME from BASIC_DETAILS where RES=\'"+resp+"\'";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+" is responsible for "+resp+"<br>");
                 }
                
            }
            
            if(!award.equals(""))
            {
                query="select NAME from AWARDS where AWARD=\'"+award+"\'";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+" received "+award+"<br>");
                 }
                
            }
            if(!faculty.equals("") && !year.equals(""))
            {
                query="select PUB from PUBLICATIONS where AUTHOR=\'"+faculty+"\' and YEAR_=\'("+year+")\'";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+"<br>");
                 }
                
            }
            
            if(phd.equals("yes"))
            {
                query="SELECT NAME,COUNT(*) AS CNT\n" +
"FROM PHD \n" +
"GROUP BY NAME\n" +
"ORDER BY COUNT(*) DESC\n" +
"FETCH FIRST ROW ONLY\n";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+" HAS MAXIMUM PHD STUDENTS  "+"<br>");
                 }
                
            }
            if(!publication.equals(""))
            {
                query="SELECT AUTHOR,COUNT(*) AS CNT FROM PUBLICATIONS WHERE YEAR_=\'("+publication+")\' GROUP BY AUTHOR ORDER BY COUNT(*) DESC FETCH FIRST ROW ONLY";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+" HAS MAXIMUM PUBLISHED PAPERS IN THE YEAR  "+publication+"<br>");
                 }
                
            }
            if(project.equals("yes"))
            {
                query="SELECT NAME,COUNT(*) AS CNT FROM PROJECTS GROUP BY NAME ORDER BY COUNT(*) DESC FETCH FIRST ROW ONLY";
                s=c.createStatement();
                rs=s.executeQuery(query);
                 while(rs.next())
                 {
                     out.println(rs.getString(1)+" HAS MAXIMUM PROJECTS <br>");
                 }
                
            }
            if(!sql.equals(""))
            {
                query=sql;
                s=c.createStatement();
                rs=s.executeQuery(query);
                System.out.println("hello");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                System.out.println("collll  :"+columnsNumber);
                 while(rs.next())
                 {
                     for(int i=1;i<=columnsNumber;i++)
                        out.println(rs.getString(i)+"   ");
                     out.println("<br>");
                 }
                
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet result1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet result1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(result1.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (SQLException ex) {
        Logger.getLogger(result1.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (SQLException ex) {
        Logger.getLogger(result1.class.getName()).log(Level.SEVERE, null, ex);
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
