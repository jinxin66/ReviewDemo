package DesignPattern.Structure.Adapter;

// 生活中一个很好的例子（电源，适配器插头，电器插头）
public class Test {
    public static void main(String[] args) {
        Plug phonePlug = new PhonePlug();
        System.out.println("默认直接充电电压" + phonePlug.output("22V"));
        System.out.println("转接220V充电电压" + phonePlug.output("220V"));
        System.out.println("转接110V充电电压" + phonePlug.output("110V"));
    }
}

