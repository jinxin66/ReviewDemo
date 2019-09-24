package Test.MultiThread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        Referee referee = new Referee();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Boolean> future = executorService.submit(referee);

        executorService.shutdownNow(); // 如果不关闭下面的线程会按序执行

        if (future.get()){
            new Thread(new Ribit()).start();
            new Turtle().start();
        }

    }
}

class Turtle extends Thread{
    @Override
    public void run() {
        int i=0;
        while (i<10000)
            System.out.println("龟走了 "+ i++ +" 步");
    }
}

class Ribit implements Runnable{
    @Override
    public void run() {
        int i=0;
        while (i<10000)
            System.out.println("兔子走了 "+ i++ +" 步");
    }
}

class Referee implements Callable<Boolean>{
    @Override
    public Boolean call() throws Exception {
        System.out.println("裁判说开始");
        return true;
    }
}

