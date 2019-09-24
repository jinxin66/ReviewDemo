package Test.MultiThread;

public class ProducerAndConsumer {
    public static void main(String [] args){
        Space space = new Space();

        new Producer(space).start();
        new Consumer(space).start();
    }
}

class Producer extends Thread{
    Space space;
    public Producer(Space space) {
        this.space = space;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000){
            i++;
            System.out.println("生产馒头" + i);
            try {
                space.push(new Bread(i));
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    Space space;
    public Consumer(Space space) {
        this.space = space;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<1000){
            i++;
            try {
                System.out.println("消费馒头" + space.pop().id);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class   Space{
    Bread[] breads = new Bread[100];
    int count = 0;

    public synchronized void push(Bread bread) throws InterruptedException {
        if (count == breads.length - 1){
            this.wait();
        }
        breads[count] = bread;
        count ++;
        this.notifyAll();
    }

    public synchronized Bread pop() throws InterruptedException {
        if (count == 0){
            this.wait();
        }
        count --;
        Bread bread = breads[count];
        this.notifyAll();

        return bread;
    }

}

class Bread{
    int id;

    public Bread(int id) {
        this.id = id;
    }
}