package commonmistakes;

public class Threads4{
 public void go() {
 Runnable r = new Runnable() {
 public void run() {
 System.out.print("foo");
 }
 };
 Thread t = new Thread(r);
 //t.start();
 t.start();
 
 }
}
class A {
 protected int method1(int a, int b) { return 0; }
 }
class b extends A
{
    private int method1(int a, long b) { 
       
 return 0; }
    
}
interface Cup {}
 class PoisonCup implements Cup {
 public static void takeCup(PoisonCup c) {
 if(c instanceof PoisonCup) //instanceof operator is used to check if an object reference belongs to a certain type
                            //or not. The type can either be an interface or a superclass.
 System.out.println("Inconceivable!");
 if(c instanceof Cup) 
 System.out.println("Dizzying intellect!");
  //else 
 //System.exit(0);
 }
 public static void main (String[] args) {
 new Threads4().go();
 String[] elements = { "for", "tea", "too" };
 String first = (elements.length > 0)? elements[0]: null;
  boolean bool = true;
  new PoisonCup();
 if(bool = false) {
 System.out.println("a");
 }
 else if (bool) {
 System.out.println("b");
 } else if (!bool) {
 System.out.println("c");
 } else {
 System.out.println("d");
 }
 PoisonCup cup = new PoisonCup();
  takeCup(cup);
  new PoisonCup().methodA();
  String str="";
  System.out.println(str.length());
   test(null);
   Object o=new Float[9];
 }
 public static void test(String str) {
 if( str.length() == 0) {                //nullpointerexception coz no object z created yet
 System.out.println("String is empty");
 } else {
 System.out.println("String is not empty");
 }
 }
 public Integer startingI;
 public void methodA() {
 Integer i = new Integer(25);
 startingI = i;
 methodB(i);
 }
 private void methodB(Integer i2) {
 i2 = i2.intValue();
System.out.println(i2 == startingI);//returns true if previous line is not der
System.out.println(i2.equals(startingI));//returns true
 }
 }