package Test;

public class StaticClassTest {
    static {
        System.out.println("load outer class...");
    }

    //静态内部类
    static class StaticInner {
        static {
            A:for(int i=0;i<2;i++)
                break A;
            System.out.println("load static inner class...");
        }

        static void staticInnerMethod() {
            System.out.println("static inner method...");
        }
    }

    public static void main(String[] args) {
        StaticClassTest outer = new StaticClassTest();      //此刻其内部类是否也会被加载？
        System.out.println("===========分割线===========");
        StaticClassTest.StaticInner.staticInnerMethod();      //调用内部类的静态方法
    }
}