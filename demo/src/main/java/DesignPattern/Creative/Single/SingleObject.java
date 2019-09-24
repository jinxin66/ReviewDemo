package DesignPattern.Creative.Single;

// 要创建单例，请将构造函数设为私有，禁用克隆，禁用扩展并创建静态变量以容纳实例
public class SingleObject {
    // 创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    // 让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}

    // 获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}

// 懒汉式1
class Singleton1_1 {
    private static Singleton1_1 instance;
    private Singleton1_1() {}
    public static Singleton1_1 getInstance() {
        if (instance == null) {
            instance = new Singleton1_1();
        }
        return instance;
    }
}

// 懒汉式2
// 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低
class Singleton1_2 {
    private static Singleton1_2 instance;
    private Singleton1_2 (){}
    public static synchronized Singleton1_2 getInstance() {
        if (instance == null) {
            instance = new Singleton1_2();
        }
        return instance;
    }
}

// 饿汉式1
// 这种方式比较常用，但容易产生垃圾对象。
class Singleton2_1{
    private static Singleton2_1 instance = new Singleton2_1();
    private Singleton2_1 (){}
    public static Singleton2_1 getInstance() {
        return instance;
    }
}

// 双检锁/双重校验锁
// 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
class Singleton3_1 {
    private volatile static Singleton3_1 singleton;
    private Singleton3_1 (){}
    public static Singleton3_1 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton3_1.class) {
                if (singleton == null) {
                    singleton = new Singleton3_1();
                }
            }
        }
        return singleton;
    }
}

// 静态内部类
// 这种方式能达到双检锁方式一样的功效，但实现更简单。
class Singleton4_1 {
    private static class SingletonHolder {
        private static final Singleton4_1 INSTANCE = new Singleton4_1();
    }
    private Singleton4_1 (){}
    public static final Singleton4_1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

// 枚举
// 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。
enum Singleton5_1 {
    INSTANCE;
    public void whateverMethod() {
    }
}