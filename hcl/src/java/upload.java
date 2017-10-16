import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
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

@WebServlet(urlPatterns = {"/upload"})

public class upload extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    public void init() throws ServletException{
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent(request)){
            throw new ServletException("Content type is not multipart/form-data");
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         System.out.println("jljl");
        out.write("<html><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"form.css\"></head><body>");
        try {
            HttpSession session=request.getSession();
             System.out.println("jjkhko000");
            List<FileItem> fileItemsList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
             System.out.println("tyttyt");
            while(fileItemsIterator.hasNext()){
                 System.out.println("97gyugf");
            request.getServletContext().setAttribute("FILES_DIR","C:\\serverfiles");
                FileItem fileItem = fileItemsIterator.next();
                System.out.println("FieldName="+fileItem.getFieldName());
                System.out.println("FileName="+fileItem.getName());
                System.out.println("ContentType="+fileItem.getContentType());
                System.out.println("Size in bytes="+fileItem.getSize());
                File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+session.getAttribute("name")+File.separator+fileItem.getName());
                System.out.println("Absolute Path at server="+file.getAbsolutePath());
                fileItem.write(file);
                out.write("this\n");
                out.write("File "+fileItem.getName()+ " uploaded successfully.");
             }
        } catch (FileUploadException e) {
            e.printStackTrace();
            out.write("Exception file.");
        } catch (Exception e) {
             e.printStackTrace();
            out.write("Exception in uploading file."+e.getMessage());
        }
        out.write("</body></html>");
    }
}