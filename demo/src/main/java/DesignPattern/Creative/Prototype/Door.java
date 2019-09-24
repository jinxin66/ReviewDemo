package DesignPattern.Creative.Prototype;

public abstract class Door implements Cloneable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract float getPay();

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class WoodDoor extends Door {
    private int wisth = 1;
    private int hight = 2;
    private float woodPrice = 5f;

    @Override
    public float getPay() {
        return wisth * hight * woodPrice;
    }
}

class IronDoor extends Door {
    private int weight = 2;
    private float fixedPrice = 10f;

    @Override
    public float getPay() {
        return weight * fixedPrice;
    }
}