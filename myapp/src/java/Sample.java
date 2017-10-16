
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
@WebServlet(urlPatterns = {"/Sample"})

public class Sample extends HttpServlet {
 public void doGet
   (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  OutputStream out = null;
  try {
   response.setContentType("application/vnd.ms-excel");
   response.setHeader
     ("Content-Disposition", "attachment; filename=sampleName.xls");
   Application app=new Application() {

       @Override
       public void start(Stage primaryStage) throws Exception {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
   };
   File xlsfile=new File("C:\\Users\\jaishree\\Desktop\\t.xls");
   Workbook w =
     app.openWorkbook(xlsfile,true,"");
 /*  WritableSheet s = w.createSheet("Demo", 0);
   s.addCell(new Label(0, 0, "Hello World"));
   w.write();
   w.close();
  }*/}
  catch (Exception e){
   throw new ServletException("Exception in Excel Sample Servlet", e);
  }
  finally{
   if (out != null)
    out.close();
  }
 }
}