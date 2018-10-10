package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class SocketChannelServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
                .bind(new InetSocketAddress(8080));

        // 设置Channel为 non-blocking 模式
        serverSocketChannel.configureBlocking(false);

        // 新建 Selector
        Selector selector = Selector.open();

        // 将 Channel 注册到 Selector，并设置监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Start Server At " + serverSocketChannel.getLocalAddress());

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true)
        {
            // 等待Selector
            selector.select();

            Iterator<SelectionKey> iterable = selector.selectedKeys()
                    .iterator();

            while (iterable.hasNext())
            {
                // 获取 SelectionKey 并从 selected keys 集合中删除.
                SelectionKey key = iterable.next();
                iterable.remove();

                // 收受新连接并加入到Selector中
                if (key.isAcceptable())
                {
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);

                    System.out.println("accept " + channel.getRemoteAddress());
                }

                // 读取数据
                if (key.isReadable())
                {
                    buffer.clear();
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.read(buffer) == -1)
                    {
                        channel.close();
                        continue;
                    }

                    buffer.flip();
                    System.out.print("read " + channel.getRemoteAddress() + "\t" + new String(buffer.array()));

                    System.out.println();
                }
            }
        }
    }
}
