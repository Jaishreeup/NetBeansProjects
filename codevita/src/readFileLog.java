
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAISHREE UPRETI
 */
public class readFileLog {
    public static void main(String[] args) throws IOException {
        Scanner obj=new Scanner(System.in);
        String keyword=obj.next();
        Map map= new HashMap();
	ArrayList<String> arlist=new ArrayList<>();
        String filename=obj.next();
        File file=new File(filename);
        System.out.println(file.exists());
	try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile())))
        {
		String sCurrentLine,temp,last="";
                int count=0;
               	while ((sCurrentLine = br.readLine()) != null) {
                {
                                temp=sCurrentLine;
                                String s[]=temp.split(" ");
                                if(s[0].charAt(4)=='-'&&s[0].charAt(7)=='-')
                                {
                                    if(map.get(s[0])==null)
                                    {
                                        map.put(s[0],0);
                                        count=0;
                                    }
                                    else
                                        count=(int)map.get(s[0]);
                                    
                                    temp=sCurrentLine;
                                    String str[]=temp.split(keyword);
                                    if(str.length>1)
                                    {
                                        count+=str.length-1;
                                        map.put(s[0],count);
                                    }
                                    last=s[0];
                                    arlist.add(s[0]);
                                }
                                else
                                {
                                    count=(int)map.get(last);
                                    temp=sCurrentLine;
                                    String str[]=temp.split(keyword);
                                    if(str.length>1)
                                    {
                                        count+=str.length-1;
                                        map.put(s[0],count);
                                    }
                                    
                                }
                            }
                                
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
            for(int i=0;i<map.size();i++)
            if((int)map.get(arlist.get(i))!=0)        
            System.out.println(arlist.get(i)+" "+map.get(arlist.get(i)));
	}
    
}
