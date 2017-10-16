
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
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
public class server {
    public static void main(String[] args) {
        try{
            String msg,reply;
            ServerSocket ss=new ServerSocket(6789);
            Socket s;
            s=ss.accept();
            BufferedReader inFromClient= new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream outToClient= new DataOutputStream(s.getOutputStream());
            while (true) {
                    msg=inFromClient.readLine();
                    System.out.println("From client: "+msg);
                    reply=msg+"\n";
                    outToClient.writeBytes(reply);       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
/*      OUTPUT
run:
From client: hello
From client: its working

*/