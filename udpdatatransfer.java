// UDP SERVER
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;

public class udpserver {
    public static void main(String [] args) throws SocketException{
        DatagramPacket pack;
        DatagramSocket sock=new DatagramSocket();

        try{
            String time=new Date().toString();
            byte[] b=time.getBytes();
            pack=new DatagramPacket(b,b.length, InetAddress.getByName("localhost"),7777);
            sock.send(pack);
        }
        catch(Exception e){
            System.out.println(e);
        }
        sock.close();
    }
}


// UDP CLIENT
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class udpclient {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sock=new DatagramSocket(7777);
        DatagramPacket pack;
        byte [] b=new byte[30];
        String data="No data";
        try {
            while (true) {
                pack = new DatagramPacket(b, b.length);
                sock.receive(pack);
                data = new String(pack.getData());
                System.out.println("Server sent " + data);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        sock.close();
    }

}
