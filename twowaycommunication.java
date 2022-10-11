// server side
import java.awt.image.DataBuffer;
import java.io.*;
import java.net.*;
public class serverside2way {
public static void main(String [] args) throws Exception{
    ServerSocket serverobject=new ServerSocket(6666); //creating server
    Socket server=serverobject.accept(); //establishing connection
    DataOutputStream ds=new DataOutputStream(server.getOutputStream()); //response
    DataInputStream dis=new DataInputStream(server.getInputStream()); // request
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //combine

    String inp="",outp="";
    while(!inp.equals("stop")){
        inp=dis.readUTF();
        System.out.println("Client says:"+inp);
        outp=br.readLine();
        ds.writeUTF(outp);
        System.out.println("Server says:"+outp);
        ds.flush();
    }
    dis.close();
    server.close();
    serverobject.close();

}
}

//client side
import java.io.*;
import java.net.*;

public class clientside2way {
public static void main(String [] args) throws Exception{
    Socket client=new Socket("localhost",6666);
    DataInputStream dis=new DataInputStream(client.getInputStream());
    DataOutputStream ds=new DataOutputStream(client.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String inp="",outp="";
    while(!inp.equals("stop")){
        inp=br.readLine();
        ds.writeUTF(outp);
        ds.flush();
        outp=dis.readUTF();
        System.out.println("Server says "+outp);

    }
    dis.close();
    client.close();
}
}
