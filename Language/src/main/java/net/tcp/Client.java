package net.tcp;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket();

        // connect
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 10000);
        socket.connect(address);

        // read
        InputStream inputStream = socket.getInputStream();
        while (true)
        {
            int i = inputStream.read();
            if (i == -1)
            {
                break;
            }

            System.out.print((char) i);
        }

        // close
        inputStream.close();
        socket.close();
    }
}
