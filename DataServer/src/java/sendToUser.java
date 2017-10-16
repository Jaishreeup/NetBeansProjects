/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(urlPatterns = {"/sendToUser"})
public class sendToUser extends HttpServlet {
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
            throws ServletException, IOException {
      response.setContentType("application/json");
        try (PrintWriter out1 = response.getWriter()) {
         
        BufferedReader  br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
         JSONObject j = new JSONObject(json);
            System.out.println(j);
            json="[";
            int bid  =Integer.parseInt( ""+j.get("bid")); 
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/busInfo");
   
                String sql="select BUS_ID,AVAILABLE_SEATS from BUSDETAILS where ROUTE_NO="+bid+"";
                s=c.createStatement();
                rs=s.executeQuery(sql);
                  while(rs.next())
                  {
                      json+="["+rs.getString(1)+","+rs.getString(2)+"],";
                  }
                  json=json.substring(0,json.length()-1);
                  json+="]";
                      
                  out1.print(json);
  
             } catch (ClassNotFoundException ex) {
          Logger.getLogger(sendToUser.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(sendToUser.class.getName()).log(Level.SEVERE, null, ex);
      } catch (JSONException ex) {
          Logger.getLogger(sendToUser.class.getName()).log(Level.SEVERE, null, ex);
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
