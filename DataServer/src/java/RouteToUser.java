
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author JAISHREE UPRETI
 */
public class RouteToUser extends HttpServlet {
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
        String json = "",str;
        if(br != null){
            json = br.readLine();
        }
         JSONObject j = new JSONObject(json);
            System.out.println(j);
            json="[";
            String src  =(String) j.get("src"); 
            String dest  =(String) j.get("dest"); 
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/busInfo");
   
                String sql="select busroute_id,route,source,destination from BUSROUTE";
                s=c.createStatement();
                rs=s.executeQuery(sql);
                  while(rs.next())
                  {
                      str=rs.getString(2);
                      if(str.contains(src)&&str.contains(dest))
                      json+="[\""+rs.getString(1)+"\",\""+str+"\",\""+rs.getString(3)+"\",\""+rs.getString(4)+"\"],";
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
