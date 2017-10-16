import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet(urlPatterns = {"/delete"})

public class delete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    public void init() throws ServletException{
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if(fileName == null || fileName.equals("")){
            throw new ServletException("File Name can't be null or empty");
        }
        PrintWriter out=response.getWriter();
         HttpSession session=request.getSession();
          out.write("<html><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"form.css\"></head><body>");
       
           String temp;
             if(session.getAttribute("name").equals("admin"))
                 temp=request.getParameter("location");
             else temp=(String)session.getAttribute("name");
           
        File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+temp+File.separator+fileName);
        if(!file.exists()){
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("hio\n");

        System.out.println("File location on server::"+file.getAbsolutePath());
        file.delete();
//        out.println("File deleted successfully");
            ServletContext ct = getServletContext();
            RequestDispatcher rd =ct.getRequestDispatcher("/view?fileName="+temp);
            rd.forward(request, response);
                        
    }
}