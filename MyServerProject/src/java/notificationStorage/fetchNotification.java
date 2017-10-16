/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package notificationStorage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fetchNotification", urlPatterns = {"/fetchNotification"})
public class fetchNotification extends HttpServlet {
Connection c;
Statement s;
ResultSet rs;
String temp="";
    private Connection dbConnection;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        try (PrintWriter out1 = response.getWriter()) {
            
             String jo="{\"results\":{";
             Class.forName("com.mysql.jdbc.Driver");
            System.out.println("yyoooooooooooooo");
                //      c=DriverManager.getConnection("jdbc:mysql://166.62.8.12/abescs","abescs","Abesec@0");
 //            c=DriverManager.getConnection("jdbc:mysql://117.55.241.6/localhost/test","test","test@321");
           c=DriverManager.getConnection("jdbc:mysql://50.62.209.148:3306/abesec_Notifier","Notifier","Qip?w666");
   
                String sql="select * from 2012BCS2211_LIST";
                    System.out.println("hherer");
                s=c.createStatement();
             rs=s.executeQuery(sql);
             
               while(rs.next())
             {
                   jo+="\""+rs.getString(1)+"\""+":[";
                 String str[]=rs.getString(2).split(",");
                 for(int i=0;i<str.length;i++)
                    jo+="\""+str[i]+"\",";//],";
                  jo=jo.substring(0,jo.length()-1);
                 jo+="],";
             }
             jo=jo.substring(0,jo.length()-1);  //removing the comma at last index
             jo+="}}";
             System.out.println(jo);
             out1.print(jo);
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(fetchNotification.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
        Logger.getLogger(fetchNotification.class.getName()).log(Level.SEVERE, null, ex);
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