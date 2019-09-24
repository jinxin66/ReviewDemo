package DesignPattern.Structure.Proxy;

public class Test {
    public static void main(String[] args) {
        Entity entity = new ProxyEntity();
        entity.setName("发动 借刀杀人 的玩家");
        entity.kill();
    }
}

abstract class Entity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void kill();
}

class RealEntity extends Entity{
    @Override
    public void kill() {
        System.out.println(getName() + "对一个玩家造成伤害");
    }
}

class ProxyEntity extends Entity{
    private RealEntity realEntity;
    @Override
    public void kill() {
        if(realEntity == null){
            realEntity = new RealEntity();
            realEntity.setName("被 借刀杀人 的玩家");
        }
        realEntity.kill();
    }
}