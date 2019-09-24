package DesignPattern.Structure.Decorator;

public class Test {
    public static void main(String[] args) {
        Car suvCar = new SuvCar();
        suvCar.setName("SUV");

        CarDecorator carDecorator = new FlyCarDecorator(suvCar);

        carDecorator.run();
    }
}

