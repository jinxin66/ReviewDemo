package DesignPattern.Creative.Factory.factorymethod;

// 它提供了一种将实例化逻辑委托给子类的方法
// 将工厂进行拆分为车间 不再需要ifesle 判断
// 用来生产同一等级结构中的固定产品。（支持增加新产品）
// 在类中有一些通用处理但在运行时动态决定所需的子类时很有用。换句话说，当客户端不知道它可能需要什么样的子类时。
public class Test {
    public static void main(String [] args){
        AbstractDoorFactory woodDoorFactory = new WoodDoorFactory();

        Door woodDoor = woodDoorFactory.makeDoor("木门");
        System.out.println(woodDoor.getName()+woodDoor.getPay()+"元");

        AbstractDoorFactory ironDoorFactory = new IronDoorFactory();

        Door ironDoor = ironDoorFactory.makeDoor("铁门");
        System.out.println(ironDoor.getName()+ironDoor.getPay()+"元");
    }
}


