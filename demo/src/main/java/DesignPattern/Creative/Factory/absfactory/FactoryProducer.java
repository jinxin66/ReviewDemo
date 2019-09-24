package DesignPattern.Creative.Factory.absfactory;

public class FactoryProducer{
    public AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("门")){
            return new DoorFactory();
        } else if(choice.equalsIgnoreCase("染料")){
            return new DyestuffFactory();
        }
        return null;
    }
}