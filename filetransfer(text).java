//FILE TRANSFER SERVER SIDE
import java.io.*;
import java.net.*;
public class filetransfer {
    public static void main(String[] args) throws Exception{
        ServerSocket sock=new ServerSocket(6666); // create server socket
        Socket s=sock.accept(); //create / establish connection with the client
        File file=new File("C:\\Users\\Prathamesh Patil\\IdeaProjects\\Firstjavaproject\\src\\index.html"); //create instance of file
        FileInputStream fis=new FileInputStream(file);//store the instance of file in input stream
        BufferedInputStream bis=new BufferedInputStream(fis); //store the input of input stream in buffer memory
        OutputStream os=s.getOutputStream();
        byte[] contents;
        long fileLength = file.length();
        long current = 0;
        while(current!=fileLength){
            int size = 10000;
            if(fileLength - current >= size)
                current += size;
            else{
                size = (int)(fileLength - current);
                current = fileLength;
            }
            contents = new byte[size];
            bis.read(contents, 0, size);
            os.write(contents);
            System.out.print("Sending file ... "+(current*100)/fileLength+"% complete!");
        }
        os.flush();
        s.close();
        sock.close();

    }
}

//FILE TRANSFER CLIENT SIDE
import java.io.*;
import java.net.*;
public class filetransferclient {
public static void main(String [] args) throws Exception{
    Socket s=new Socket("localhost",6666);
    byte[] contents = new byte[10000];
    //Initialize the FileOutputStream to the output file's full path.
    FileOutputStream fos = new FileOutputStream("C:\\Users\\Prathamesh Patil\\IdeaProjects\\Firstjavaproject\\src\\chimes-7037.mp3");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    InputStream is = s.getInputStream();
    //No of bytes read in one read() call
    int bytesRead = 0;
    while((bytesRead=is.read(contents))!=-1)
        bos.write(contents, 0, bytesRead);
    bos.flush();
    s.close();
    System.out.println("File saved successfully!");
}
}


