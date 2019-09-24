package DesignPattern.Structure.Adapter;

public abstract class StandardSocket{
    public abstract int output110();
    public abstract int output220();
}

class StandardSocket220V extends StandardSocket{
    @Override
    public int output110() {
        return 0;
    }

    @Override
    public int output220() {
        return 220;
    }
}

class StandardSocket110V extends StandardSocket{
    @Override
    public int output110() {
        return 110;
    }

    @Override
    public int output220() {
        return 0;
    }
}