package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelClient
{
    public static void main(String[] args) throws IOException
    {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8080));

        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("Hello".getBytes());

        buffer.flip();
        channel.write(buffer);

        channel.close();

        System.out.println("Write Succeed");
    }
}
