package Test.MultiThread;

public class VolatilTest {
    /*
    volatile关键字简单理解
    cpu cache 主存
    JMM 模型 线程 工作区 主存
    线程先read方式将变量读取然后load方式载入工作区 成为副本，cpu use方式调用 assing写回工作区，变量发生改变，写回主存
    因为 在总线层 MWSI缓存一致协议 ，cpu嗅探机制监听到变量写入，硬件实现使其他线程变量副本失效，其他进程重新执行read\load
    */
    private  static volatile boolean flg = false;
    public static void main(String [] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(flg);
                while (!flg){

                }
                System.out.println("flg变为"+flg);
            }
        }).start();

        Thread.sleep(2000); //让两个线程不同时运行

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始改变");
                flg = true;
                System.out.println("改变完成");
            }
        }).start();
    }

}
