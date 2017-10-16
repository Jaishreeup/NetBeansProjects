import java.util.Scanner;
public class t
{
  public static void main(String a[])
  {
    Scanner o=new Scanner(System.in);
    int n=o.nextInt();
    o.nextLine();
    for(int j=1;j<n+1;j++)
    {
      String str=o.nextLine();
//        System.out.println(str);
      String s[]=str.split(" ");
      int len=s.length;
      System.out.print("Case #"+j+": ");
      for(int i=len-1;i>0;i--)
        System.out.print(s[i]+" ");
      System.out.println(s[0]);
    }    
  }
}