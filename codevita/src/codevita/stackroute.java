/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.ArrayList;

/**
 *
 * @author JAISHREE UPRETI
 */
public class stackroute {
    public static void main(String[] args) {
        
        int input1=3;
        String[] input2={"11","3","44","12","26","13","21","33","21"};
        String[] input3={"33","44","11","3","13","12","21","26","21"};
        ArrayList arr[],arr1[],newarr[];
        arr = new ArrayList[input1];//();
        arr1 = new ArrayList[input1];//();
        newarr = new ArrayList[input1];//();
        int t=0;
        for(int j=0;j<input1;j++)
        {
            arr[j]=new ArrayList();
            arr1[j]=new ArrayList();
            newarr[j]=new ArrayList();
            for(int i=0;i<input1;i++)
        {
            arr[j].add(input2[t]);
            arr1[j].add(input3[t++]);
        }
        }
        
        int count=0,yup=0,flag=0,column=0,index;
       for(int i=0;i<input1;i++)
       {
           if(!arr1[0].contains(arr[0].get(i)))
           {
               count++;
               if(arr1[1].contains(arr[0].get(i)))
               { yup=1;column=i;}
           }
       }
       if(count!=1)
           flag=1;
       if(count==1&&yup!=1)
           flag=1;
       String temp=(String)arr[input1-1].get(column);
       for(int i=input1-1;i>0;i--)
       {
           arr[i].remove(column);
           arr[i].add(column,arr[i-1].get(column));
       }
       arr[0].remove(column);
       arr[0].add(column,temp);
        
      for (int i = 0; i < input1; i++) {
            if(arr1[i].contains(arr[i].get(0)))
                    {
                        index=arr1[i].indexOf(arr[i].get(0));
                     //   System.out.println("hi  "+index);
       for(int j=0;j<input1;j++)
       {
           t=(j-index)%input1;
           if(t<0)t=input1+t;
           newarr[i].add(j,arr[i].get(t));
       }
                         
        }
            else flag=1;
    }
        
        
        String ret;
        for (int i = 0; i < input1; i++) 
            for(int j=0;j<input1;j++)
                if(arr1[i].get(j)!=arr1[i].get(j))
                { flag=1;break;}
            if(flag==1)
                System.out.println( "no");
            else System.out.println("yes");
        }
    }

