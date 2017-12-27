package net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        String receive = new String(bytes, packet.getOffset(), packet.getLength());

        System.out.println(packet.getSocketAddress());
        System.out.println(receive);

        socket.close();
    }
}
