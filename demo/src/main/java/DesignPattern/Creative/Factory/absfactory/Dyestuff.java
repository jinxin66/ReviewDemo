package DesignPattern.Creative.Factory.absfactory;

public abstract class Dyestuff{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void dye();
}

class RedDyestuff extends Dyestuff{
    @Override
    public void dye() {
        System.out.println("用红色染料染色");
    }
}

class BlueDyestuff extends Dyestuff{
    @Override
    public void dye() {
        System.out.println("用蓝色染料染色");
    }
}