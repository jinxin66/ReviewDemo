package DesignPattern.Structure.Adapter;

public abstract class Plug{
    public abstract int output(String input);
}

class AdapterPlug extends Plug{
    StandardSocket supplyElect;
    AdapterPlug(String input){
        if (input.equals("220V"))
            supplyElect = new  StandardSocket220V();
        else if (input.equals("110V"))
            supplyElect = new  StandardSocket110V();
    } // 初始化适配器时同样要进行适配操作，可以理解为选择适配器

    @Override
    public int output(String input){
        if (input.equals("220V"))
            return supplyElect.output220() / 10;
        else if (input.equals("110V"))
            return supplyElect.output110() / 5;
        else
            return 0; // 进行适配操作，否则适配失败
    }
}

class PhonePlug extends Plug{
    AdapterPlug adapterPlug;
    @Override
    public int output(String input) {
        if (input.equals("22V"))
            return 22;
        else{
            adapterPlug = new AdapterPlug(input);
            return adapterPlug.output(input);
        } // 不适配就调用适配器插头
    }
}