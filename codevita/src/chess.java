
import java.util.Scanner;

public class chess {
    
    public static void main(String[] args) {
        String line;
        char board[][]=new char[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                board[i][j]='0';
        int len,num,chance=0,init=0,temp=0,count=0;
        String str="";
        Scanner obj=new Scanner(System.in);
        line=obj.nextLine();
        while(!line.equals("-1"))
        {
            str="";
            String arr[]=line.split("/");
            for(int i=0;i<8;i++)
            {
                num=0;
                    for(int j=0;j<arr[i].length();j++)
                    {
                            if(arr[i].charAt(j)>'0'&&arr[i].charAt(j)<='9')
                            {
                                init=num;
                                num+=Integer.parseInt(""+arr[i].charAt(j));
                                for(int k=init;k<num;k++)
                                    board[i][k]='0';
                             }
                            else
                            {
                                if(board[i][num]!='0'&&board[i][num]!=arr[i].charAt(j))
                             {
                                 if(arr[i].charAt(j)!='p'&&arr[i].charAt(j)!='P')
                                   str=""+arr[i].charAt(j);
                            //     else str+=
                                    str+="x";
                                    count++;
                             
                                    switch(num)
                                    {
                                            case 0:str+="a";break;
                                            case 1:str+="b";break;
                                            case 2:str+="c";break;
                                            case 3:str+="d";break;
                                            case 4:str+="e";break;
                                            case 5:str+="f";break;
                                            case 6:str+="g";break;
                                            case 7:str+="h";break;
                                    }
                                    str+=8-i;
                             }
                                else if(board[i][num]=='0')
                                {
                                    if(arr[i].charAt(j)!='p'&&arr[i].charAt(j)!='P')
                                   str=""+arr[i].charAt(j);
                                    
                                    switch(num)
                                    {
                                            case 0:str+="a";break;
                                            case 1:str+="b";break;
                                            case 2:str+="c";break;
                                            case 3:str+="d";break;
                                            case 4:str+="e";break;
                                            case 5:str+="f";break;
                                            case 6:str+="g";break;
                                            case 7:str+="h";break;
                                    }
                                    str+=8-i;
                             }
                             
                                 board[i][num]=arr[i].charAt(j);
                             
                                    num++;
                                    
                            }
                    }
                }/*
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                    System.out.print(" "+board[i][j]);
                System.out.println();
            }*/
            chance++;
            temp++;
            System.out.println("asdasd");
            if(temp!=1)
            if(chance%2==0)
            {
                System.out.print(temp/2+") ");
     
                System.out.print(str+ " ");
           //     chance=0;
            }
            else
                System.out.println(str+" ");
        line=obj.nextLine(); 
        }
        System.out.println();
        System.out.println("Number of Captures : "+count);
        }
    }
