package DesignPattern.Creative.Factory.factorymethod;

public abstract class AbstractDoorFactory{
    public abstract Door makeDoor(String name);
}

class WoodDoorFactory extends AbstractDoorFactory{
    @Override
    public Door makeDoor(String name){
        Door door = new WoodDoor();
        door.setName(name);
        return door;
    }
}

class IronDoorFactory extends AbstractDoorFactory{
    @Override
    public Door makeDoor(String name){
        Door door = new IronDoor();
        door.setName(name);
        return door;
    }
}