package net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket socket = new ServerSocket();

        // bind port
        InetSocketAddress address = new InetSocketAddress(10000);
        socket.bind(address);

        // accept
        Socket client = socket.accept();

        // read write
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        outputStream.write("Hello".getBytes());

        // close
        inputStream.close();
        outputStream.close();
        client.close();
        socket.close();
    }
}
