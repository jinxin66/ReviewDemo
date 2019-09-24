package DesignPattern.Creative.Builder;

public abstract class Car{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void run();
}

class SuvCar extends Car{
    @Override
    void run() {
        System.out.println(this.getName() + "run");
    }
}

class StnCar extends Car{
    @Override
    void run() {
        System.out.println(this.getName() + "run");
    }
}