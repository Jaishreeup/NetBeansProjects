/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.Scanner;

/**
 *
 * @author JAISHREE UPRETI
 */
public class bestfriendship {
   
    
    public static void main(String a[])
    {int n,m,temp1,temp2;
    String s1="",s2="",str="",processed="";
    int inp1[],inp2[];
        Scanner obj=new Scanner(System.in);
        n=obj.nextInt();
        m=obj.nextInt();
        //s1+=obj.nextInt();
        //s2+=obj.nextInt();
        inp1=new int[m];
        inp2=new int[m];
      //  System.out.println(s1+" "+s2);
        for(int i=0;i<m;i++)
        {
            inp1[i]=obj.nextInt();
            inp2[i]=obj.nextInt();
        }
         temp1=inp1[0];
                s1+=temp1;
                str="";
                str+=inp2[0];
                for(int j=1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s2+=str;
                temp1=inp2[0];
                s2+=temp1;
                str="";
                str+=inp1[0];
                for(int j=1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s1+=str;
processed+=inp1[0]+inp2[0];
        for(int i=1;i<m;i++)
        {
            
         temp1=inp1[i];
 if(!processed.contains(""+temp1))                     
{     
        processed+=temp1;     
        if(s1.contains(""+temp1))
            {
                str="";
                str+=inp2[i];
                for(int j=i+1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s2+=str;
            }
        else
            {
                str="";
                str+=inp2[i];
                for(int j=i+1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s1+=str;
            }           
            }   
temp2=inp2[i];
 if(!processed.contains(""+temp2))                     
{     
        processed+=temp1;     
        if(s1.contains(""+temp1))
            {
                str="";
                str+=inp1[i];
                for(int j=i+1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s2+=str;
            }
        else
            {
                str="";
                str+=inp1[i];
                for(int j=i+1;j<m;j++)
                {
                    if(inp1[j]==temp1)
                    str+=inp2[j];
                    else if(inp2[j]==temp1)
                    str+=inp1[j];
                }
                s1+=str;
            }          
}   
}
        for(int i=1;i<n+1;i++)
        {
            if(s1.contains(""+i)&&s2.contains(""+i))
                System.out.println("No");
            else
                System.out.println("Yes");
        }
}
}




