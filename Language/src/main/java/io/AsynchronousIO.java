package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.concurrent.Future;

public class AsynchronousIO
{
    public static void main(String[] args) throws IOException
    {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("settings.gradle"));

        ByteBuffer buffer = ByteBuffer.allocate(128);

        Future<Integer> future = channel.read(buffer, 0);

        while (!future.isDone()) ;

        buffer.flip();
        System.out.println(new String(buffer.array()));
    }
}
