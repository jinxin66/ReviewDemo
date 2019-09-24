package DesignPattern.Creative.Builder;

public abstract class CarBuilder{
    Car car = null;
    public abstract void installWheels();
    public abstract void installWindows();
    public abstract void installDoors();
    public Car buildCar(){
        installWheels();
        installWindows();
        installDoors();;
        return car;
    }
}

class SuvCarBuilder extends CarBuilder{
    @Override
    public void installWheels() {
        car = new SuvCar();
        car.setName("SUV");
        System.out.println(car.getName() + "安装轮子");
    }

    @Override
    public void installWindows() {
        car = new SuvCar();
        car.setName("SUV");
        System.out.println(car.getName() + "安装窗子");
    }

    @Override
    public void installDoors() {
        car = new SuvCar();
        car.setName("SUV");
        System.out.println(car.getName() + "安装门");
    }
}


class StnCarBuilder extends CarBuilder{
    @Override
    public void installWheels() {
        car = new StnCar();
        car.setName("STN");
        System.out.println(car.getName() + "安装门");
    }

    @Override
    public void installWindows() {
        car = new StnCar();
        car.setName("STN");
        System.out.println(car.getName() + "安装窗子");
    }

    @Override
    public void installDoors() {
        car = new StnCar();
        car.setName("STN");
        System.out.println(car.getName() + "安装门");
    }
}