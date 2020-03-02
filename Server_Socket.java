import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.*;
import java.io.*;
public class Server_Socket
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    public Server_Socket(int port)
    {
        try{
            server = new ServerSocket(port);
            System.out.println("Server Started...");
            System.out.println("Waiting For Client...");
            socket = server.accept();
            System.out.println("Client Accepted..");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while(!line.equals("over"))
            {
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing Connection...");
            socket.close();
            in.close();

        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        new Server_Socket(5000);
    }
}