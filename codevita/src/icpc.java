
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
 class icpc {

    public static void main(String[] args) {
        int len,num,mod;
        Scanner obj=new Scanner(System.in);
        String str=obj.next();
        len=str.length();
        int q=obj.nextInt();
        int m[]=new int[q];
         int l[]=new int[q];
          int count[]=new int[q];
        for(int i=0;i<q;i++)
        {
            m[i]=obj.nextInt();
            l[i]=obj.nextInt();
            count[i]=0;
        } //  System.out.println("m :"+m+" l :"+l);
            for(int j=1;j<=len;j++)
            {
                for(int k=0;k<len-j+1;k++)
                {
                    num=Integer.parseInt(str.substring(k, k+j));
                   for(int i=0;i<q;i++)
                   {
                    mod=num%m[i];
//                   System.out.println("num :"+num+" mod :"+mod);
                    if(mod==l[i])count[i]++;
                   }
                }
            }
            for(int i=0;i<q;i++)
            System.out.println(count[i]);
        }
    }

