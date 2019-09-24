package Test.MultiThread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTest {
    /*
    synchronized关键字简单理解
    */
    private AtomicInteger atomicInteger = new AtomicInteger();
    private  static  int flg = 0;
    private static synchronized void add(){
        flg++;
    }
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++)
                    add();
                System.out.println(flg);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++)
                    add();
                System.out.println(flg);
            }
        }).start();
    }

}
