package DesignPattern.Structure.Flyweight;

import java.util.HashMap;

public class DoorFactory {

    private static final HashMap<String, Door> doorMap = new HashMap<>();

    public static Door makeDoor(String name) {
        Door door = doorMap.get(name);

        if(door == null) {
            if (name.equals("木门")){
                door = new WoodDoor();
                door.setName(name);
            }
            else if (name.equals("铁门")){
                door = new IronDoor();
                door.setName(name);
            }
            doorMap.put(name, door);
            System.out.println("成功新增元");
        }
        return door;
    }
}