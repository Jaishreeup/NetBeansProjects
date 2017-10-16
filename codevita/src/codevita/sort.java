/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JAISHREE UPRETI
 */
public class sort {
    public static void main(String[] args) {
        
    Scanner obj=new Scanner(System.in);
        int t=obj.nextInt(),n,count=0;
        String name;
        String arr[],temp;
        obj.nextLine();
           
        for(int i=1;i<=t;i++)
        {
            count=0;
            n=Integer.parseInt(obj.nextLine());
            arr=new String[n];
            for(int j=0;j<n;j++)
            {
                name=obj.nextLine();
                arr[j]=name;
            }
            for(int j=0;j<n-1;j++)
                if(arr[j].compareTo(arr[j+1])>0)
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    count++;
                }
                System.out.println("Case #"+i+": "+count);
        }
        }
}
