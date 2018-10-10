package io;

import java.nio.ByteBuffer;

public class Buffer
{
    public static void main(String[] args)
    {
        ByteBuffer buffer = ByteBuffer.allocate(32);

        // 写数据
        buffer.put("Hello".getBytes());

        // 将写模式切换成读模式
        buffer.flip();

        // 读数据
        while (buffer.hasRemaining())
        {
            System.out.print((char) buffer.get());
        }

        // 重新读Buffer
        buffer.rewind();
        System.out.println(new String(buffer.array()));

        // 标记位置
        buffer.mark();

        // 回到标记位置
        buffer.reset();

        // 清空数据
        buffer.clear();

        // 清空已经读取的数据，未读取的数据移到到起始处
        buffer.compact();
    }
}
