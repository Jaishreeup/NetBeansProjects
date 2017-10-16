package a;

import java.util.Scanner;
public class fb{
    static int x=6;
    public static void main(String args[])
    {
        String n;
        int len,j,min,max,temp;
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
         obj.nextLine();
        for(int i=0;i<t;i++)
        {
            n=obj.nextLine();
            len=n.length();
            if(len==1)
            {
                System.out.println("Case #"+(i+1)+": "+n+" "+n);
            }
            else
            {
                int ar[]=new int[len];
                int br[]=new int[len];
                char[] charArray = n.toCharArray();
                for( j=0;j<len;j++)
                {
                    ar[j]=Character.getNumericValue(charArray[j]);
                    br[j]=ar[j];
                }
                int count=0,flag=0,var=0,var1=0,leftmostzero=0;
                for(j=1;j<len;j++)
                 if(ar[j]==ar[0]||ar[j]==0)
                 {
                     if(ar[j]==0)
                     {
                         if(flag==0)
                         {
                             flag=1;
                             leftmostzero=j;
                         }
                         var=j;
                     }
                     else if(ar[j]==ar[0])
                         var1=j;
                     count++;
                 }
                if(count==len-1)
                 {
                     System.out.println("hi");
                     if(flag==1&&var1!=0)
                     {
                         temp=ar[1];
                        ar[1]=ar[var];
                        ar[var]=temp;
                        if(var1>leftmostzero)
                        {
                          temp=br[var1];
                          br[var1]=br[leftmostzero];
                          br[leftmostzero]=temp;
                        }
                     }
                     
                }
             else
              { min=0;
                max=0;
                for(j=1;j<len;j++)
                {
                    if(ar[j]<=ar[min]&&ar[j]!=0)
                        min=j;
                    if(ar[j]>=ar[max])
                        max=j;
                }
                if(ar[min]==ar[0]&&min!=0)
                {
                 for(j=1;j<len;j++)
                   if(ar[j]==0)
                      var=j;
                      if(var!=0)
                      {
                          temp=ar[1];
                          ar[1]=ar[var];
                          ar[var]=temp;
                      }
                      else
                      {
                          
                 for(j=1;j<len;j++)
                   if(ar[j]!=ar[min])
                   {
                           temp=ar[j];
                          ar[j]=ar[min];
                          ar[min]=temp;
                          break;
                      }
                      }
                }
                else
                {
                    temp=ar[0];
                    ar[0]=ar[min];
                    ar[min]=temp;
                }
                if(ar[max]==ar[0]&&max!=0)
                {
                 for(j=1;j<len;j++)
                   if(br[j]!=br[max])
                   {
                      temp=br[j];
                      br[j]=br[max];
                      br[max]=temp;
                      break;
                   }
                } 
                else
                {
                    temp=br[0];
                    br[0]=br[max];
                    br[max]=temp;
                }
                }
                System.out.print("Case #"+(i+1)+": ");
                for(j=0;j<len;j++)
                System.out.print(ar[j]); 
                System.out.print(" ");
                for(j=0;j<len;j++)
                System.out.print(br[j]);
                System.out.println("");
            }
        }
            
        }
            
}