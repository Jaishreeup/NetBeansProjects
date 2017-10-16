package com.journaldev.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "admin";
	private final String password = "password";
        Connection c;
        ResultSet rs;
        Statement s;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                c=DriverManager.getConnection("jdbc:derby://localhost:1527/webproject");
                s=c.createStatement();
                // get request parameters for userID and password
                String user = request.getParameter("user");
                String pwd = request.getParameter("pwd");
                String sql="select * from LOGINDETAILS where username='"+user+"' and password='"+pwd+"'";
                rs=s.executeQuery(sql);
              
                if(rs.next()){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    //setting session to expiry in 1 mins
                    session.setMaxInactiveInterval(1*60);
                    Cookie userName = new Cookie("user", user);
                    response.addCookie(userName);
                    String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
                    response.sendRedirect(encodedURL);
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/main.html");
                    PrintWriter out= response.getWriter();
                    out.println("<font color=red>Either user name or password is wrong.</font>");
                    rd.include(request, response);
                }
            c.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

}
