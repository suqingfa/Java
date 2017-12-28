package net;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Time
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("time-a.nist.gov", 13));

        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        socket.close();
    }
}
