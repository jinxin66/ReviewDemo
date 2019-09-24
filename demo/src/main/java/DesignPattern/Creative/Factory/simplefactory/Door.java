package DesignPattern.Creative.Factory.simplefactory;

public abstract class Door{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract float getPay();
}

class WoodDoor extends Door{
    private int wisth = 1;
    private int hight = 2;
    private float woodPrice = 5f;

    @Override
    public float getPay() {
        return wisth * hight * woodPrice;
    }
}

class IronDoor extends Door{
    private int weight = 2;
    private float fixedPrice = 10f;

    @Override
    public float getPay() {
        return weight * fixedPrice;
    }
}