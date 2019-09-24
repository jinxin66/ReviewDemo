package DesignPattern.Creative.Factory.simplefactory;

public class DoorFactory{
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
}