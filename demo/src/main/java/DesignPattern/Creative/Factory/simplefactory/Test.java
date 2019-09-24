package DesignPattern.Creative.Factory.simplefactory;

// 简单工厂只是为客户端生成一个实例，而不会向客户端公开任何实例化逻辑
// 通过对传入值进行if else 判断决定返回种类
// 用来生产同一等级结构中的任意产品。（对于增加新的产品，无能为力）也叫 静态工厂模式
// 当创建一个对象不仅仅是一些分配而且涉及一些逻辑时，将它放在专用工厂中而不是在任何地方重复相同的代码是有意义的。
public class Test {
    public static void main(String [] args){
        DoorFactory doorFactory = new DoorFactory();

        Door woodDoor = doorFactory.makeDoor("木门");
        System.out.println(woodDoor.getName()+woodDoor.getPay()+"元");

        Door ironDoor = doorFactory.makeDoor("铁门");
        System.out.println(ironDoor.getName()+ironDoor.getPay()+"元");
    }
}