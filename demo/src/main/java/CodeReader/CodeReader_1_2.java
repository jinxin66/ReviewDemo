package CodeReader;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class CodeReader_1_2 {
    public static void main(String [] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 5; i > 0; i--) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("=========================");
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }
        try {
            countDownLatch.wait(100);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    ReadWriteLock readWriteLock = new ReadWriteLock() {
        @Override
        public Lock readLock() {
            return null;
        }

        @Override
        public Lock writeLock() {
            return null;
        }
    };

    Condition condition;

    ForkJoinPool forkJoinPool = new ForkJoinPool();

    synchronized void setA() throws Exception{
        Thread.sleep(1000);
        setB();
    }
    synchronized void setB() throws Exception{
        Thread.sleep(1000);
    }
}
