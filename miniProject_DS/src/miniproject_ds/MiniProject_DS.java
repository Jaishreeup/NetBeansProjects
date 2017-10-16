/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miniproject_ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAISHREE UPRETI
 */
public class MiniProject_DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // FileInputStream fin1=null;
        try {
            // TODO code application logic here
            File f1=new File("C:\\Users\\JAISHREE UPRETI\\Documents\\NetBeansProjects\\miniProject_DS\\src\\miniproject_ds\\master.txt");
            File f2=new File("C:\\Users\\JAISHREE UPRETI\\Documents\\NetBeansProjects\\miniProject_DS\\src\\miniproject_ds\\details.txt");
            File f3=new File("C:\\Users\\JAISHREE UPRETI\\Documents\\NetBeansProjects\\miniProject_DS\\src\\miniproject_ds\\result.txt");
            BufferedReader br = new BufferedReader(new FileReader(f1));
            BufferedWriter b=new BufferedWriter(new FileWriter(f3.getAbsoluteFile()));
            br.readLine();
            String record;
       
            Map map= new HashMap();
            Map map1=new HashMap();
            while((record=br.readLine())!=null)
            {
                String[] str=record.split("           ");
                map.put(str[0],str[2]);
                map1.put(str[0],str[1]);
            }
            br = new BufferedReader(new FileReader(f2));
            br.readLine();
            String entry;
            while((entry=br.readLine())!=null)
            {
                String[] str=entry.split("               ");
                String temp=(String)map.get(str[0]);
                int i=Integer.parseInt(temp);
                if(str[1].equals("D"))
                    i-=Integer.parseInt(str[2]);
                else
                    i+=Integer.parseInt(str[2]);
                map.put(str[0],""+i);
                System.out.println(str[0]+" "+map1.get(str[0])+" "+i);
                b.write(str[0]+" "+map1.get(str[0])+" "+i);
        }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(MiniProject_DS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MiniProject_DS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        
        
    }
    
}
