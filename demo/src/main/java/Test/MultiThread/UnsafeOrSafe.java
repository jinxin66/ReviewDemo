package Test.MultiThread;

class Accoubt{
    String name;
    int money;

    public Accoubt(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Cogo{
    String name;
    int num;

    public Cogo(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

public class UnsafeOrSafe {
    public static void main(String [] args) {
        UnsafeWeb unsafeWeb = new UnsafeWeb(
                new Accoubt("我",10000),new Cogo("车票",1000));

//        new Thread(unsafeWeb,"手机").start();
//        new Thread(unsafeWeb,"自助机").start();
//        new Thread(unsafeWeb,"柜台").start();

        SafeWeb safeWeb = new SafeWeb(
                new Accoubt("小明",1000),new Cogo("小米",100));

        new Thread(safeWeb,"手机").start();
        new Thread(safeWeb,"PC").start();
        new Thread(safeWeb,"柜台").start();

    }
}

class UnsafeWeb implements Runnable{
    Accoubt accoubt;
    Cogo cogo;
    boolean flog = true;

    public UnsafeWeb(Accoubt accoubt, Cogo cogo) {
        this.accoubt = accoubt;
        this.cogo = cogo;
    }

    @Override
    public void run() {
        while (flog){
            try {
                Thread.sleep(1);
                test();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void test() throws InterruptedException {
        cogo.num--;
        Thread.sleep(1);
        accoubt.money-=10;

        Thread.sleep(1);

        System.out.println(accoubt.name +
                "在" + Thread.currentThread().getName() +
                "买后结余" + accoubt.money);
        System.out.println("剩余商品数：" + cogo.num);

        if (cogo.num<=0 || accoubt.money<=0)
            flog = false;
    }
}

class SafeWeb implements Runnable{
    Accoubt accoubt;
    Cogo cogo;
    boolean flog = true;

    public SafeWeb(Accoubt accoubt, Cogo cogo) {
        this.accoubt = accoubt;
        this.cogo = cogo;
    }

    @Override
    public void run() {
        while (flog){
            try {
                Thread.sleep(1);
                test();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void test() throws InterruptedException {
        if (cogo.num<=0 || accoubt.money<=0){
            flog = false;
            return;
        } // 判断是否继续用于优化性能

        synchronized (this){
            if (cogo.num<=0 || accoubt.money<=0){
                flog = false;
                return;
            } //最后一张判断

            cogo.num--;
            Thread.sleep(1);
            accoubt.money-=10;
            Thread.sleep(1);

            System.out.println(accoubt.name +
                    "在" + Thread.currentThread().getName() +
                    "买后结余" + accoubt.money);
            System.out.println("剩余商品数：" + cogo.num);
        }
    }
}