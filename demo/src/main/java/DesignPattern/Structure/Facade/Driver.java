package DesignPattern.Structure.Facade;

public class Driver{
    private Car suvCar;
    private Car stnCar;

    public Driver() {
        this.suvCar = suvCar = new SuvCar();
        this.stnCar = stnCar = new StnCar();
    }

    public void driverSuv() {
        suvCar.run();
    }

    public void driverStn() {
        stnCar.run();
    }
}