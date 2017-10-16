/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miniproject_ds;
/**
 *
 * @author JAISHREE UPRETI
 */
public class test {
    public static void main(String[] args)throws Exception {
        try{
            throw new Exception();
        }
        catch(Exception e)
        {
            System.out.println("Hello");
        }
        finally{
            System.out.println("No error");
        }
    }
    
}
class ex
{
    class t extends Exception{}
    public void runT() throws t{}
    public void test() throws Exception{ runT();}
    }

