package DesignPattern.Structure.Bridge;

// jdbc 就是一个很好的桥接模式
public class Test {
    public static void main(String[] args) {
        Demo mysqlDemo = new MysqlDemo(new MySqlJDBC());
        mysqlDemo.getlink("127.0.0.1:3306");

        Demo oracleDemo = new OracleDemo(new OracleJDBC());
        oracleDemo.getlink("127.0.0.1:9312");
    }
}