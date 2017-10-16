/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JAISHREE UPRETI
 */
 class avant {
    public static void main(String[] args) {
        long  ans;
        int m,l,r,k;
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        while(t--!=0)
        {
           ArrayList map;
           int n=obj.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++)
                a[i]=obj.nextInt();
            m=obj.nextInt();
            for(int i=0;i<m;i++)
            {
            /*     map = new ArrayList<>();
                ans=0;
                k=0;
              */  l=obj.nextInt();
                r=obj.nextInt();
                /*for(int j=l-1;j<r;j++)
                {
                    if(!map.contains(a[j]))
                    {
                        map.add(a[j]);
                    }
                }
                for(int j=0;j<map.size();j++)
                    ans+=(j+1)* (int)map.get(j);
                *///System.out.println(ans);
            }
            
        }
    }
    
}
