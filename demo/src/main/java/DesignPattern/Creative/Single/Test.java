package DesignPattern.Creative.Single;

public class Test {
    public static void main(String[] args) {

        //不合法的构造函数,编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        Runtime runtime = Runtime.getRuntime();
        //private static Runtime currentRuntime = new Runtime();
        System.out.println("jdk中的RunTime就是一个单例"+ runtime);

        //显示消息
        object.showMessage();
    }
}