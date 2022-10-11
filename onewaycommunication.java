// Server Side
import java.io.*;
import java.net.*;

public class ABC {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s=ss.accept();
            System.out.println("Server Started");
            DataInputStream di=new DataInputStream(s.getInputStream());
            String str=di.readUTF();
            System.out.println("Message from client "+str);
            ss.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}


// Client side
import java.io.*;
import java.net.*;

public class PQR {
    public static void main(String[] args){
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream ds = new DataOutputStream(s.getOutputStream());
            ds.writeUTF("Hi!!! Hello");
            ds.flush();
            ds.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
