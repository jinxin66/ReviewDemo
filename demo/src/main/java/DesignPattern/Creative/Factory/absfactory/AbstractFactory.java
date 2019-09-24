package DesignPattern.Creative.Factory.absfactory;

public abstract class AbstractFactory{
    public abstract Door makeDoor(String name);
    public abstract Dyestuff makeDyestuff(String color);
}

class DoorFactory extends AbstractFactory{
    @Override
    public Door makeDoor(String name){
        Door door = null;
        if (name.equals("木门")){
            door = new WoodDoor();
            door.setName(name);
        }
        else if (name.equals("铁门")){
            door = new IronDoor();
            door.setName(name);
        }
        return door;
    }

    @Override
    public Dyestuff makeDyestuff(String color) {
        return null;
    }
}

class DyestuffFactory extends AbstractFactory{
    @Override
    public Door makeDoor(String name){
        return null;
    }

    @Override
    public Dyestuff makeDyestuff(String color) {
        Dyestuff dyestuff = null;
        if (color.equals("红色")){
            dyestuff = new RedDyestuff();
            dyestuff.setColor(color);
        }
        else if (color.equals("蓝色")){
            dyestuff = new BlueDyestuff();
            dyestuff.setColor(color);
        }
        return dyestuff;
    }
}