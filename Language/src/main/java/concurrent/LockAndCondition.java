package concurrent;

import java.util.concurrent.locks.*;

public class LockAndCondition
{
    public static void main(String[] args) throws Exception
    {
        // 普通锁
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        // 读写锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        writeLock.unlock();

        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        readLock.unlock();

        // 条件变量
        Condition condition = new ReentrantLock().newCondition();
        condition.signal();
        condition.await();
    }
}
