
import static java.lang.Math.*;
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
public class radar {
    public static void main(String[] args) {
    //cout<<fixed<<setprecision(5);
    double x,y,m,an,co,si,z,totarea,marea,remarea,peri,PI= 3.14159265;
    Scanner obj=new Scanner(System.in);
        System.out.println("hi");
    x=obj.nextDouble();
    y=obj.nextDouble();
   // z=obj.nextDouble();
    m=obj.nextDouble();
    an=obj.nextDouble();
     System.out.println(an);
    co=cos(an*PI/180.0);
    String coo=""+co;
        System.out.println(coo);
    String temp[]=coo.split(".");
    System.out.println("here"+temp.length);
    if(temp.length==2&&temp[1].length()+temp[0].length()>11&&temp[1].length()>11-temp[0].length())
    {
        System.out.println("here");
        temp[1]=temp[1].substring(0,10-temp[0].length());
    }
    co=Double.parseDouble(temp[0]+temp[1]);
        System.out.println(co);
    si=sin(an*PI/180.0);
    z=sqrt(x*x+y*y-2*x*y*co);
    peri=(x+y+z)/2;
    totarea=sqrt(peri*(peri-x)*(peri-y)*(peri-z));
    marea=(an/2)*m*m*PI/180;
    remarea=totarea-marea;
        System.out.println(remarea);
        System.out.println(z);
}
}