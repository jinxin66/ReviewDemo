package DesignPattern.Structure.Flyweight;

public class Test {
    public static void main(String[] args) {
        DoorFactory doorFactory = new DoorFactory();

        Door woodDoor = doorFactory.makeDoor("木门");
        System.out.println(woodDoor.getName()+woodDoor.getPay()+"元");

        Door ironDoor = doorFactory.makeDoor("木门");
        System.out.println(ironDoor.getName()+ironDoor.getPay()+"元");
    }
}
