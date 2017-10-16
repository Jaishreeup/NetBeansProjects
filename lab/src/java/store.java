/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet(urlPatterns = {"/store"})

public class store extends HttpServlet {
    Connection conn;
    Statement st;
    String name="",resp="",desig="",email="",phone="",website="",research="",t="",t1="",temp="";
//    File file=new File("output.txt");
    private final String FILENAME = "C:\\Users\\JAISHREE UPRETI\\Documents\\NetBeansProjects\\lab\\src\\java\\output.txt";
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        BufferedReader br = null;
		FileReader fr = null;
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                 conn=DriverManager.getConnection("jdbc:derby://localhost:1527/faculty_data");
   
              
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine = null;

			br = new BufferedReader(new FileReader(FILENAME));
                        sCurrentLine = br.readLine();
                if((sCurrentLine = br.readLine()) != null)
                        if(sCurrentLine.contains("NAME")){
                            
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                          


                                        name=sCurrentLine;
                                        System.out.println("name is:"+name);
                                    }
                                }
                
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
                                if(sCurrentLine.contains("NAME")){
                                    System.out.println("got name");
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                    
                                        System.out.println("prev :"+t +"cur :"+t1);
                                        if(resp.equals(t))resp="";
      if(research.equals(t1))research="";
                                                                    
//      System.out.println("hiiii");
                                        String sql="insert into BASIC_DETAILS values(\'"+name+"\',\'"+desig+"\',\'"+resp+"\',\'"+email+"\',\'"+phone+"\',\'"+website+"\',\'"+research+"\')";
                st=conn.createStatement();
                t=resp;
                                        System.out.println("thiis is:"+st.executeUpdate(sql));
                                        name=sCurrentLine;
                                    System.out.println(name);
                                        
                                    }
                                }
                                else if(sCurrentLine.contains("DESIGNATION")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                        desig=sCurrentLine;
                                    } 
                                }
                                else if(sCurrentLine.contains("RESPONSIBILITY")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                        t=resp;
                                        resp=sCurrentLine;
                                    } 
                                }
                                else if(sCurrentLine.contains("EMAIL")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                        email=sCurrentLine;
                                    //  System.out.println(email);
                                      //  email.replace("@","\\@");
                                    
                                    } 
                                }
                                else if(sCurrentLine.contains("PHONE")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                        phone=sCurrentLine;
                                    } 
                                }
                                else if(sCurrentLine.contains("WEBSITE")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                        website=sCurrentLine;
                                    } 
                                }
                                else if(sCurrentLine.contains("RESEARCH")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    {
                                           t1=research;
                                     
                                        research=sCurrentLine;
                                    } 
                                }
                                else if(sCurrentLine.contains("PUBLICATION")){
                                    if((sCurrentLine = br.readLine()) != null)
                                    temp+=sCurrentLine;
                                    //System.out.println("this is\n"+temp);
                                     if((sCurrentLine = br.readLine()) != null)
                                         temp+=sCurrentLine;
                                      if((sCurrentLine = br.readLine()) != null)
                                          temp+=sCurrentLine;
                                     if((sCurrentLine = br.readLine()) != null)
                                          temp+=sCurrentLine;
                                     // System.out.println("temp: "+temp);
                                      sCurrentLine = br.readLine();
                                      sCurrentLine = br.readLine();
                                     sCurrentLine=sCurrentLine.trim();
                                      // temp+=sCurrentLine;
                                     //System.out.println(name+" "+sCurrentLine);
                                      String sql="insert into PUBLICATIONS values(\'"+name+"\',\'"+temp+"\',\'"+sCurrentLine+"\')";
                st=conn.createStatement();
                st.executeUpdate(sql);
                
                temp="";
                                }
                                else if(sCurrentLine.contains("PROJECTS")){
                                    sCurrentLine = br.readLine();
                                      String sql="insert into PROJECTS values(\'"+name+"\',\'"+sCurrentLine+"\')";
                st=conn.createStatement();
                st.executeUpdate(sql);
             
                                    
                                }
                                else if(sCurrentLine.contains("AWARDS")){
                                    sCurrentLine = br.readLine();
                                      String sql="insert into AWARDS values(\'"+name+"\',\'"+sCurrentLine+"\')";
                st=conn.createStatement();
                st.executeUpdate(sql);
             
                                }
                                
                                
                                else if(sCurrentLine.contains("Ph.D. Students")){
                                    System.out.println("phd.");
                                    
                                    while((sCurrentLine = br.readLine()).contains("STUDENT"))
                                             {
                                     
                                     String sname = br.readLine();
                                     System.out.println("current line: "+sname);
                                     sCurrentLine = br.readLine();
                                     System.out.println("current line: "+sCurrentLine);
                                     sCurrentLine = br.readLine();
                                     System.out.println("current line: "+sCurrentLine);
                                     
                                      String sql="insert into PHD values(\'"+name+"\',\'"+sname+"\',\'"+sCurrentLine+"\')";
                st=conn.createStatement();
                st.executeUpdate(sql);
              
                                }
                                  if(sCurrentLine.contains("MS Students")){
                                   
                                    while((sCurrentLine = br.readLine())!=null && sCurrentLine.contains("STUDENT"))
                                             {
                                     
                                     String sname = br.readLine();
                                     System.out.println("current line: "+sname);
                                     sCurrentLine = br.readLine();
                                     System.out.println("current line: "+sCurrentLine);
                                     sCurrentLine = br.readLine();
                                     System.out.println("current line: "+sCurrentLine);
                                     if(sCurrentLine!=null){
                                         //System.out.println("hi");
                                      String sql="insert into MS values(\'"+name+"\',\'"+sname+"\',\'"+sCurrentLine+"\')";
                st=conn.createStatement();
                st.executeUpdate(sql);
                                     }
                                }
                                      System.out.println("current line: "+sCurrentLine);
                                }
                     
                        }
                        
                        }
                        
                                           System.out.println("prev :"+t +"cur :"+resp);
                                        if(resp.equals(t))resp="";
      if(research.equals(t1))research="";
                                                                    
//      System.out.println("hiiii");
                                        String sql="insert into BASIC_DETAILS values(\'"+name+"\',\'"+desig+"\',\'"+resp+"\',\'"+email+"\',\'"+phone+"\',\'"+website+"\',\'"+research+"\')";
                st=conn.createStatement();
                t=resp;
                                        System.out.println("thiis is:"+st.executeUpdate(sql));
                                        name=sCurrentLine;
                                    System.out.println(name);
                                 
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

                
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet storeToDb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet storeToDb at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(storeToDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(storeToDb.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(storeToDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(storeToDb.class.getName()).log(Level.SEVERE, null, ex);
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
