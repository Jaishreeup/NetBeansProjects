
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAISHREE UPRETI
 */
public class clientA {
    public static void main(String[] args) {
        try{
            String msg,reply;
            BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
            Socket s=new Socket("localhost",6789);
            DataOutputStream outToServer=new DataOutputStream(s.getOutputStream());
            BufferedReader inFromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {                
                msg=inFromUser.readLine();
                if(msg.equals("exit"))
                    break;
                outToServer.writeBytes(msg+"\n");
                reply=inFromServer.readLine();
                System.out.println("from server: "+reply);
            }
            inFromServer.close();
            outToServer.close();
            s.close();
            inFromUser.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
}
}

/*      OUTPUT
run:
hello
from server: hello
its working
from server: its working

*/