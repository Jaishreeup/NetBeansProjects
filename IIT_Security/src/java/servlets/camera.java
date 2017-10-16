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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAISHREE UPRETI
 */
@WebServlet(name = "camera", urlPatterns = {"/camera"})
public class camera extends HttpServlet {
    private String inout;
    private String t2;
    private String t1;
    private String d2;
    private String d1;
    private int time2;
    private int time1;
     static Connection c;
    static Statement s;
  static ResultSet rs;
    private static String reg,model;
    private String errant="no";


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
  
        try {                                      
                     Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          c=DriverManager.getConnection("jdbc:derby://localhost:1527/iis");
   

            // TODO add your handling code here:
            reg=request.getParameter("registration");
            model=request.getParameter("model");
            inout=(request.getParameter("enter/exit"));
            System.out.println("hiiiiiiiiiiiiii "+reg+" "+model);
            String sql="select * from BARRED where regno='"+reg+"' and model='"+model+"'";
           System.out.println(sql);
           
            s=c.createStatement();
            rs=s.executeQuery(sql);
            if(rs.next())
            {
             System.out.println("Sorry the vehicle is barred!!");
             //display html
             RequestDispatcher rd=getServletContext().getRequestDispatcher("/camera.html");
             rd.include(request, response);
             out.print("Sorry the vehicle is barred!!");
    
            }
            else
            {
            //check if errant vehicle 
            sql="select errant from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
            s=c.createStatement();
                 System.out.println(sql);
           
            rs=s.executeQuery(sql);
            if(rs.next())
            errant=rs.getString(1);
            else errant="no";
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calobj = Calendar.getInstance();
            System.out.println(df.format(calobj.getTime()));
            String str[]=df.format(calobj.getTime()).split(" ");
            s=c.createStatement();
             sql="select * from vehicles where reg_no='"+reg+"' and model='"+model+"'";
                System.out.println(sql);
             rs=s.executeQuery(sql);
            if(rs.next()){
                System.out.println("cheching if true "+inout);
                System.out.println("GATE IS LIFTED");
                out.print("<center><br>GATE IS LIFTED<br><center> ");
                  RequestDispatcher rd=getServletContext().getRequestDispatcher("/camera.html");
                rd.include(request, response);
                out.print("<center><br>GATE IS LIFTED<br><center> ");
                
                      //new Alert(this,true).main(new String[]{"Lift gate!!"});
                if(inout.equals("entry"))
                {
//                    sql="update IN__OUT_LOG set entrytime='"+str[1]+"',entrydate='"+str[0]+"' where reg='"+reg+"' and model='"+model+"'";
//                    s.executeUpdate(sql);
                    sql="select * from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
                    s=c.createStatement();
                    rs=s.executeQuery(sql);
                    rs.next();
                    sql="insert into history values('"+rs.getString(1)+"','"+rs.getString(2)+"','"+str[1]
                            +"','"+rs.getString(4)+"','"+str[0]+"','"+rs.getString(6)
                            +"','"+rs.getString(7)+"','"+rs.getString(8)+"')";
                    s=c.createStatement();
                    System.out.println(sql);
                    s.executeUpdate(sql);
                     sql="delete from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
                    s=c.createStatement();
                    s.executeUpdate(sql);
                    System.out.println(sql);
                     //transfer details to history table
                      
                }
                else
                {
                    System.out.println("str:"+str[1]);
                    sql="insert into IN_OUT_LOG values('"+reg+"','"+model+"','00:00:00','"+str[1]+"','0002-11-30','"+str[0]+"','in','no','null')";
                    System.out.println(sql);
                    s.executeUpdate(sql);
                } 
                 rd=getServletContext().getRequestDispatcher("/camera.html");
                     rd.forward(request, response);
            
            //details regarding entry and exit of vehicles
            }
            else
            {
                System.out.println("vehicle not registered...");
                //SHOW PURPOSE PAGE AND STORE DETAILS IN DB 
                
                if(inout.equals("entry"))
                {
                    System.out.println("entry");
                    //outside form for purpose
                      RequestDispatcher rd=getServletContext().getRequestDispatcher("/outside.html");
                      request.getSession().setAttribute("reg", reg);
                      request.getSession().setAttribute("model", model);
                      request.getSession().setAttribute("t0",str[0]);
                      request.getSession().setAttribute("t1", str[1]);
                      
                      System.out.println(reg+" ooooooooooo "+model);
                      rd.forward(request, response);

////                   
//                        sql="insert into IN_OUT_LOG values('"+reg+"','"+model+"','"+str[1]+"','00:00:00','"+str[0]+"','0000-00-00','out')";
//                        System.out.println(sql);
//                        s.executeUpdate(sql);
                
                }
                else
                {
                    System.out.println("exit "+errant);
                    if(errant.equals("yes"))
                    {
                        System.out.println("this outside vehicle is errant");
                    
                    //show errant response page
                    RequestDispatcher rd=getServletContext().getRequestDispatcher("/errant_response.html");
                         request.getSession().setAttribute("time",str[1]);
                            request.getSession().setAttribute("reg",reg);
                            request.getSession().setAttribute("model",model);
                            request.getSession().setAttribute("date",str[0]);
                        
                    rd.forward(request, response);
                    }
                    else
                    {
                    sql="update IN_OUT_LOG set exittime='"+str[1]+"',exitdate='"+str[0]+"' where regno='"+reg+"' and model='"+model+"'";
                    s.executeUpdate(sql);
                    sql="select * from IN_OUT_LOG where regno='"+reg+"' and model='"+model+"'";
                    s=c.createStatement();
                    rs=s.executeQuery(sql);
                    if(rs.next())
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
                        mins =  Integer.parseInt(hourMin[1]);
                        hoursInMins = hour * 60;
                        time1= hoursInMins + mins;

                        if((time2-time1)/60.0>.04)
                        {
                            System.out.println("LATE EXIT......");
                            RequestDispatcher rd=getServletContext().getRequestDispatcher("/late.html");
                            request.getSession().setAttribute("time",str[1]);
                            request.getSession().setAttribute("reg",reg);
                            request.getSession().setAttribute("model",model);
                            request.getSession().setAttribute("date",str[0]);
                            rd.forward(request, response);
                         //   new late_8_hours().main(null);
                        }
                      RequestDispatcher   rd=getServletContext().getRequestDispatcher("/camera.html");
                     rd.forward(request, response);
            
                    }
                }
                }
//                
               // new outside_vehicle().main(null);
            }
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
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
