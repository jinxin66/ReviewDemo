package DesignPattern.Creative.Prototype;

// 通过克隆基于现有对象创建对象
// 当需要一个与现有对象类似的对象时，或者与克隆相比，创建的成本会很高。
public class Test {
    public static void main(String[] args) {
        Door woodDoor = new WoodDoor();
        woodDoor.setId(1);
        woodDoor.setName("木门");

        Door ironDoor = (Door) woodDoor.clone();
        woodDoor.setId(2);
        System.out.println("IronDoor : " + ironDoor.getName());
    }

}
