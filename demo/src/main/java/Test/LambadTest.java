package Test;

import java.util.concurrent.*;

public class LambadTest {


    public static void main(String [] args) throws ExecutionException, InterruptedException {
        // 外部类
        new Turtle().start();

        // 静态内部类

        // 方法内部类
        class Ribit extends Thread{
            @Override
            public void run() {
                int i=0;
                while (i<10000)
                    System.out.println("龟走了 "+ i++ +" 步");
            }
        }
        Ribit ribit = new Ribit();

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        // 简化为lambad
        new Thread(() -> {
            System.out.println();
        }).start();

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