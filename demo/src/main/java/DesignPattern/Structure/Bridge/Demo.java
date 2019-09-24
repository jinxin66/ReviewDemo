package DesignPattern.Structure.Bridge;

public abstract class Demo{
    protected JDBC jdbc;

    Demo(JDBC jdbc) {
        this.jdbc = jdbc;
    }

    public abstract void getlink(String url);
}

class MysqlDemo extends Demo{
    MysqlDemo(JDBC jdbc){
        super(jdbc);
    }

    @Override
    public void getlink(String url) {
        jdbc.link(url);
    }
}

class OracleDemo extends Demo{
    OracleDemo(JDBC jdbc){
        super(jdbc);
    }

    @Override
    public void getlink(String url) {
        jdbc.link(url);
    }
}