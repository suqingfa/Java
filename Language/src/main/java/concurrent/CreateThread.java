package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThread
{
    public static void main(String[] args)
    {
        // 原生线程
        new Thread(() -> System.out.println("Hello")).start();

        // 线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++)
        {
            pool.execute(() -> System.out.println(Thread.currentThread()
                    .getId()));
        }
        pool.shutdown();

        // fork-join 框架

    }
}
