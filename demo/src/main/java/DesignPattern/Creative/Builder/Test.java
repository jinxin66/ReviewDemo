package DesignPattern.Creative.Builder;

// 创建一个创建者来负责 对象的装配，例如：创建一个装配师来负责车子的门、窗、轮的装配
public class Test {
    public static void main(String[] args) {
        CarBuilder suvCarBuilder = new SuvCarBuilder();
        Car suvCar = suvCarBuilder.buildCar();
        suvCar.run();

        CarBuilder stnCarBuilder = new StnCarBuilder();
        Car stnCar = stnCarBuilder.buildCar();
        stnCar.run();
    }
}

