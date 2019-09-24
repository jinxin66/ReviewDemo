package DesignPattern.Structure.Facade;

public class Test {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.driverSuv();
        driver.driverStn();
    }
}