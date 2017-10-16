package commonmistakes;
class temp
{
    private temp(int a)
    {
    System.out.println(a+" parameterized"+c);
    }
    int c=10;
    int lol;// variables dat r nt local need not be explicitly initialized
    { System.out.println("my my ");}//this will be printed whenever an obj is created
    temp()//a default constructor is a must if der is parameterized otherwise new temp() will gice compilation error 
    {
        System.out.println("default ");
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    void check()
    {int novalue = 0;//local variable has to be initialized explicitely before use
    System.out.println(novalue+" "+c);
    temp t=new temp(5);
    }
    static { System.out.println("y y ");}//this will be printed when the 1st object of this class will be created
}
 class SomeException {
 }
 class A1 {
 public void doSomething() { }
 }
 class B1 extends A1 {
// public void doSomething() throws SomeException { }
 }
public class test// in one java file,there can be atmost 1 public class which should contain the main method
{                        //if more than 1 public class,implies error
    static public void main(String args[])
    {
        System.out.println(Boolean.valueOf("TRue1"));//returns true only if the string is"true" not case sensitive
        System.out.println(Integer.SIZE);
        int a=10,b=-3;
            System.out.println(a/b);
            System.out.println(a%b);
     int i=16;
      System.out.println(++i+" "+i+++" "+i);
      i=2;
      int fin=i++ + ++i+--i+i++ +i;//ans=16 calculate from left to ryt
      System.out.println("this is the fin:"+fin);
      float f=67.9F;
      String s="hello";
      String s1=("hello");
      String s2=new String("hello");
      System.out.println(s1==s2);
      System.out.println(s1==s);
      System.out.println(s==s2);
      System.out.println(s1.equals(s2));
      System.out.println(s.equals(s2));
      System.out.println(s1.equals(s));
      i=1;
      long lo=1l;
      switch(i)//it cant have long float double string as argument
      {
          default:System.out.println("hi");
                 break;
          case 2:System.out.println("yo");
           //   case 1:System.out.println("o");
      }
      /*for(int j=0,k=2;;)
      {
    }*/
      
      temp t1=new temp();
      t1.check();
    int arr[];
    int [] ar={1,2,3,4,5};
    int[] aar;
    int []ar1;
    temp[] t=new temp[2];
    t[0]=new temp();
    t[1]=new temp();
    temp[] te={new temp(),new temp(),new temp()};
    int[] numbers={1,2,0x43,043,5};//we can give octal n hex. no.
    int sum=0;
    for( int item : numbers)//enhanced for loop to traverse arrays
    {
        sum=sum+item;
    }
    System.out.println("sum is:"+sum+" "+numbers[2]);
    //sum=0;
    for( temp item : t)//enhanced for loop to traverse arrays
    {
        sum=sum+item.c;
    }
     System.out.println("sum is:"+sum);
     System.out.println("this is"+args[0]);
     int j=Integer.parseInt(args[0]);
    byte k=Byte.parseByte(args[1]);
    double d=Double.parseDouble(args[2]);
    char ch=args[3].charAt(0);
    int[][] array;
    int array1[][];
    int[][] array2=new int[2][]; //giving d number of rows is compulsory
    int x=3;
    //if(x) will give error since x is int not boolean
    if(x!=0)//works fyn
    {
    }
    boolean bool;
    if(bool=true)//assignment in booleans can be done but not any other datatype
    {
    }
    }
   
}
    interface Status {
    final static public int x=1;  //ordering does not matter
    public static final int y=3;
    static final public int z=9;
    }
interface Foo {
    public static final int x=10;
    int bar(); }
 class Sprite {
 public int fubar( Foo foo) { return foo.bar(); }
 public void testFoo() {
 fubar(new Foo() { public int bar(){return 1; } });
 }
}
 class Test1 {
 public enum Dogs {collie, harrier, shepherd};
 public static void main1(String [] args) {
 Dogs myDog = Dogs.shepherd;
 switch (myDog) {
 case collie:System.out.print("collie ");
 case harrier:System.out.print("harrier ");
 default: System.out.print("retriever ");
 }
 }
 }
