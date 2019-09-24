package DesignPattern.Creative.Factory.absfactory;

// 将个人但相关/依赖工厂分组在一起而不指定其具体类别的工厂。
// 创建一个工厂创造器/生成器类，通过传递工厂种类信息来获取工厂。
// 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）
// 当存在相互关联的依赖关系时，涉及非简单的创建逻辑
public class Test {
    public static void main(String [] args){
        FactoryProducer factoryProducer = new FactoryProducer();

        AbstractFactory doorFactory = factoryProducer.getFactory("门");

        Door woodDoor = doorFactory.makeDoor("木门");
        System.out.println(woodDoor.getPay());

        AbstractFactory dyestuffFactory = factoryProducer.getFactory("染料");

        Dyestuff redDyestuff = dyestuffFactory.makeDyestuff("红色");
        redDyestuff.dye();

        Door ironDoor = doorFactory.makeDoor("铁门");
        System.out.println(ironDoor.getPay());

        Dyestuff blueDyestuff = dyestuffFactory.makeDyestuff("蓝色");
        blueDyestuff.dye();
    }
}


