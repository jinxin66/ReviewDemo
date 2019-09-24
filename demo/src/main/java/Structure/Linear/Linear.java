package Structure.Linear;

interface List {
    public abstract void initList();
    public abstract int lenth();
    public abstract Object get(Object obj);
    public abstract Object get(int index);

    public abstract void add();
    public abstract void add(int index);

    public abstract void remove(int index);
    public abstract void reprice(int index);

    public abstract boolean isEnpity();
}


