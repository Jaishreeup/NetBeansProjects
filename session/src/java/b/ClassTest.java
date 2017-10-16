package b;
 import a.ClassOne;
 public class ClassTest extends ClassOne {
 public static void main(String[] args) {
 char a = new ClassOne().getVar();
 char b = new ClassTest().getVar();
 }
 }