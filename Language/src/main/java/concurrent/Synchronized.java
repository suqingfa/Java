package concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronized
{
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;

    private static final Object synchronizedObject = new Object();

    private static Lock lock = new ReentrantLock();

    private static int N = 10000;
    private static Semaphore semaphore = new Semaphore(-4 * N + 1);


    public static void main(String[] args) throws Exception
    {
        Instant start = Instant.now();

        ExecutorService pool = Executors.newFixedThreadPool(32);
        for (int i = 0; i < N; i++)
        {
            pool.execute(Synchronized::incA);
            pool.execute(Synchronized::incB);
            pool.execute(Synchronized::incC);
            pool.execute(Synchronized::incD);
        }

        semaphore.acquire();
        pool.shutdown();

        System.out.println(Duration.between(start, Instant.now()));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    private static void incA()
    {
        a++;
        semaphore.release();
    }

    private synchronized static void incB()
    {
        b++;
        semaphore.release();
    }

    private static void incC()
    {
        synchronized (synchronizedObject)
        {
            c++;
        }
        semaphore.release();
    }

    private static void incD()
    {
        lock.lock();
        d++;
        lock.unlock();
        semaphore.release();
    }
}
