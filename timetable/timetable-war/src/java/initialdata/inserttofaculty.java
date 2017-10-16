package initialdata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class inserttofaculty 
{
	static Connection c;
	static Statement s;
        static String str[]={"cse","ece","eee"};
	public static void writetofaculty(String name,int i)
	{
		System.out.println(name);
		try
		{
			String sql="insert into "+str[i]+" values ('"+name+"')";
			s.executeUpdate(sql);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		try 
		{
                        String files[]=
                        {
                            "C:\\Users\\jaishree\\Downloads\\x.txt",
                            "C:\\Users\\jaishree\\Downloads\\y.txt",
                            "C:\\Users\\jaishree\\Downloads\\z.txt"
                        };
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			c=DriverManager.getConnection("jdbc:derby://localhost:1527/timetable","shantanu","jaishree");                   
			s = c.createStatement();
                        for(int i=0;i<3;i++)
                        {
                            File file = new File(files[i]);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null)
				writetofaculty(line,i);
			fileReader.close();
		        }
                }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace(System.out);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
