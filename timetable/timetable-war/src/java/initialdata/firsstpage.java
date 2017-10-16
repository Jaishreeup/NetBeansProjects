package initialdata;
import com.jniwrapper.win32.jexcel.*;
import com.jniwrapper.win32.jexcel.ui.JWorkbook;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
class firstpage
{
    public static void main(String args[])
    {
        try {
            // Simple JWorkbook-based application
            JFrame frame= new JFrame("Test application");
            
            frame.setDefaultCloseOperation (
                    javax.swing.WindowConstants.EXIT_ON_CLOSE
            );
            
            Container cp = frame.getContentPane();
            
            cp.setLayout( new BorderLayout());
            
            JWorkbook workbook = new JWorkbook();
            
            cp.add(workbook);
            
            frame.setBounds(100, 100, 500, 500 );
            
            frame.setVisible(true);
            // Gets reference to active worksheet
            
            Worksheet sheet=workbook.getActiveWorksheet();
            
// Creates 2d double array and fills the range
            
            final int  ARRAY_SIZE = 5 ;
            
            double  dcount = 0 ;
            
            final double  double_array[][] =
                    
                    new  double[ARRAY_SIZE][ARRAY_SIZE] ;
            
            for(int i=0; i < ARRAY_SIZE; i++) {
                
                for (int j =0; j < ARRAY_SIZE ; j++)
                    
                { double_array[i][j] = dcount++;}
                
            }
            
            sheet.fillWithArray("A1:E5",double_array);
        } catch (ExcelException ex) {
            Logger.getLogger(firstpage.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}