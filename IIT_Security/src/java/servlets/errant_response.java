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
import static servlets.camera.s;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "errant_response", urlPatterns = {"/errant_response"})
public class errant_response extends HttpServlet {
    private Connection c;
    private Statement s;
    private String reg;
    private ResultSet rs;
    private String t2;
    private String t1;
    private String d2;
    private String d1;
    private int time2;
    private int time1;

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
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           String reg=(String)request.getSession().getAttribute("reg");
           String model=(String)request.getSession().getAttribute("model");
           String str=(String)request.getSession().getAttribute("date");
           String str1=(String)request.getSession().getAttribute("time");
           String  sql;
           c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
           sql="update errant_log as cd set reason='"+request.getParameter("purpose")+"' where regno='"+reg+"' and model='"+model+"' AND not exists (select 1 from errant_log as cd2"
                     +" where cd2.regno = cd.regno and cd2.model = cd.model and cd2.date > cd.date)";
           s=c.createStatement();
           System.out.println(sql);
                      s.executeUpdate(sql);
           
           if(request.getParameter("sat/unsat").equals("unsatisfactory"))
            {    
            sql="insert into barred values ('"+reg+"','"+model+"')";
                 s=c.createStatement();
                      s.executeUpdate(sql);
            }
            {
                sql="update IN_OUT_LOG set exittime='"+str1+"',exitdate='"+str+"' where regno='"+reg+"' and model='"+model+"'";
                    s.executeUpdate(sql);
                    sql="select * from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
                    s=c.createStatement();
                    System.out.println(sql);
                    rs=s.executeQuery(sql);
                    if(rs.next())
                    {
                        System.out.println("got it!!!");
                    sql="insert into history values('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)
                            +"','"+rs.getString(4)+"','"+rs.getString(5)+"','"+rs.getString(6)
                      +"','"+rs.getString(7)+"','"+rs.getString(8)+"')";
                    s=c.createStatement();
                    s.executeUpdate(sql);
                    t2=rs.getString(4);
                    t1=rs.getString(3);
                    d2=rs.getString(6);
                    d1=rs.getString(5);
                    }
                    sql="delete from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
                    s=c.createStatement();
                    s.executeUpdate(sql);
               
                    if(d1.equals(d2))
                    {
                        String[] hourMin = t2.split(":");
                        int hour = Integer.parseInt(hourMin[0]);
                        int mins = Integer.parseInt(hourMin[1]);
                        int hoursInMins = hour * 60;
                        time2= hoursInMins + mins;

                        hourMin = t1.split(":");
                        hour = Integer.parseInt(hourMin[0]);
                        mins = Integer.parseInt(hourMin[1]);
                        hoursInMins = hour * 60;
                        time1= hoursInMins + mins;

                        if((time2-time1)/60.0>.04)
                        {
                            System.out.println("LATE EXIT......");
                            RequestDispatcher rd=getServletContext().getRequestDispatcher("/late.html");
                            request.getSession().setAttribute("time",str1);
                            request.getSession().setAttribute("reg",reg);
                            request.getSession().setAttribute("model",model);
                            request.getSession().setAttribute("date",str);
                            rd.forward(request, response);
                         //   new late_8_hours().main(null);
                        }
                          RequestDispatcher   rd=getServletContext().getRequestDispatcher("/camera.html");
                     rd.forward(request, response);
            
                    }
                }
                
  
                  } catch (SQLException ex) {
                      Logger.getLogger(errant_response.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (ClassNotFoundException ex) {
            Logger.getLogger(errant_response.class.getName()).log(Level.SEVERE, null, ex);
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
