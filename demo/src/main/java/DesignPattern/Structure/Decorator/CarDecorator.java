package DesignPattern.Structure.Decorator;

public abstract class CarDecorator extends Car{
    protected Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    public void run(){
        decoratedCar.run();
    }
}

class FlyCarDecorator extends CarDecorator{
    public FlyCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void run() {
        decoratedCar.run();
        setDecorator(decoratedCar);
    }

    private void setDecorator(Car car){
        System.out.println(car.getName() + " Can Fly");
    }
}