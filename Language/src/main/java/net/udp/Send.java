package net.udp;

import java.net.*;

public class Send
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket socket = new DatagramSocket();

        byte[] bytes = "Hello".getBytes();
        InetAddress sendTo = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, sendTo, 9999);
        socket.send(packet);

        socket.close();
    }
}
