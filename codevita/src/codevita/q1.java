/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author JAISHREE UPRETI
 */
public class q1 {
    
    public static void main(String[] args) {
        int p,m,n,t = 0,sum,temp;
        Scanner obj=new Scanner(System.in);
        t=obj.nextInt();
            for(int i=1;i<=t;i++)
    {
        Map map=new HashMap();
        //System.out.println("yoooooooooooo");
      
        ArrayList ar=new ArrayList<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap sorted_map = new TreeMap(bvc);
        p=obj.nextInt();
        //System.out.println("hhhhhhhhhhhhhhh");
        int s[]=new int[p+1];
        String name[]=new String[p+1];
        for(int j=1;j<=p;j++)
        s[j]=obj.nextInt();;
        n=obj.nextInt();
        int w[]=new int[n+1];
        //System.out.println("jjjjjjjjjjj");
        for(int j=1;j<=n;j++)
        {
            w[j]=obj.nextInt();
            for(int k=1;k<=p;k++)
            {
                name[k]=obj.next();
                temp=w[j]*s[k];
                if(!(map.containsKey(name[k])))
                {
                    ar=new ArrayList<>();
                    ar.add(temp);
                    map.put(name[k],ar);
                }
                else
                {
                    ar=(ArrayList) map.get(name[k]);
                    ar.add(temp);
                    map.put(name[k],ar);
                }
            }
       //     System.out.println("kkkkkkkkkkkkkkkkkkk");
           // System.out.println("hello "+j);
        }
        
        m=obj.nextInt();
        int size=map.size(),tt=0;
            Comparator comparator = Collections.reverseOrder();
 for ( Object key : map.keySet() ) {
            
     //System.out.println("noooooooooooooo");
     ar=(ArrayList)map.get(key) ;
     //System.out.println("aaaaaaaaaa");
            Collections.sort(ar,comparator);
            sum=0;
           // System.out.println("ppppppppppp");
            
            for(int j=0;j<m&&j<ar.size();j++)
            {
                sum+=(int)ar.get(j);
            }
            //System.out.println("yyyyyyyyy");
            map.put(key, sum);
        }
        //System.out.println("llllllllllllllll");
            //System.out.println(map);
            sorted_map.putAll(map);
            TreeSet sortSet=new TreeSet() {};
            int last = 0,ss=1,count=0;
            Object str;
       //     System.out.println(sorted_map);
            System.out.println("Case #"+i+": ");
            for ( Object key : sorted_map.keySet() ) {
                
            sum=(int)map.get(key);
           //System.out.println(last+"  "+sum);
            if(count==0)
            {
             //   System.out.println("hii");
                sortSet.add(key);
                last=sum;
               //     System.out.println(sortSet);
                count++;
            }
            else if(sum==last)
            {
                //System.out.println("jjjjjjjj");
                sortSet.add(key);
                
                  //  System.out.println(sortSet);
                last=sum;
                //count++;
            }
            else 
            {
                tt+=ss;
                ss=0;
                 while(!sortSet.isEmpty())
                { 
                    str=sortSet.first();ss++;
                    System.out.println(tt+": "+str);
                    sortSet.remove(str);
                   // System.out.println(sortSet);
                }
                sortSet=new TreeSet();
                sortSet.add(key);
                last=sum;
            
               
            }
    }
      tt+=ss;
             while(!sortSet.isEmpty())
                { 
                    str=sortSet.first();
                    System.out.println(tt+": "+str);
                    sortSet.remove(str);
                   // System.out.println(sortSet);
                }
            
}
}
}
class ValueComparator implements Comparator {
    Map base;

    public ValueComparator(Map base) {
        this.base = base;
    }


    @Override
    public int compare(Object a, Object b) {
       if ((int)base.get(a) >= (int)base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys

    }

   
}