package DesignPattern.Structure.Bridge;

public abstract class JDBC{
    public abstract void link(String url);
}

class MySqlJDBC extends JDBC{
    @Override
    public void link(String url) {
        System.out.println("连接 MySql" + url);
    }
}

class OracleJDBC extends JDBC{
    @Override
    public void link(String url) {
        System.out.println("连接 Oracle" + url);
    }
}