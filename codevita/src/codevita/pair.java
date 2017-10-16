/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codevita;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author JAISHREE UPRETI
 */

public class pair {
static int m,
      graph[][];
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt(),count=0;
        String s1,s2;
        Map map;
        boolean flag;
        for(int i=1;i<=t;i++)
        {
            map=new HashMap();
            graph=new int[200][200];
            count=0;
            flag=true;
            m=obj.nextInt();
            for(int j=0;j<m;j++)
            {
                s1=obj.next();
                s2=obj.next();
                if(!map.containsKey(s1))
                    map.put(s1,count++);
                if(!map.containsKey(s2))
                    map.put(s2, count++);
                graph[(int)map.get(s1)][(int)map.get(s2)]=1;
                graph[(int)map.get(s2)][(int)map.get(s1)]=1;
            }
            color = new int[2 * m];
            Arrays.fill(color, -1);
            if(isPossible(0, 0))
            System.out.println("Case #"+i+": Yes");
            else
                 System.out.println("Case #"+i+": No");
            
        }
                
    }
     static int color[];
        
    
  static  boolean isPossible(int x, int c) {
        color[x] = c;
        boolean p = true;
        for (int i = 0; i < 2 * m; ++i) {
            if (graph[x][i]==1) {
                if (color[i] == c) {
                    return false;
                } else if (color[i] == -1) {
                    p = p && isPossible(i, 1 - c);
                }
            }
        }
        return p;
    }

}
