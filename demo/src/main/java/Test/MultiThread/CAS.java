package Test.MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    private static AtomicInteger atomicInteger = new AtomicInteger(5);
    public static void main(String [] args){
        int i = 0;
        while (i<5){
            i++;
            new Thread(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = atomicInteger.decrementAndGet();
                if (left<1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println("还有" + left);
            }).start();
        }
    }
}
