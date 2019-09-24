package DesignPattern.Structure.Composite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 组合模式允许客户以统一的方式处理单个对象。
public class Test {
    public static void main(String[] args) {
        Form form = new Form();
        form.setOrder(new Order(1,"新订单",new Date()));

        List<Pproduct> productList = new ArrayList<Pproduct>();
        productList.add(new Pproduct(1,"商品1",15));
        productList.add(new Pproduct(1,"商品2",15));
        form.setPproductList(productList);

        System.out.println(form.getPay());
    }
}

class Form{
    private Order order;

    private List<Pproduct> pproductList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Pproduct> getPproductList() {
        return pproductList;
    }

    public void setPproductList(List<Pproduct> pproductList) {
        this.pproductList = pproductList;
    }

    public int getPay(){
        int result = 0;
        for (Pproduct pproduct : pproductList)
            result = result + pproduct.getPrice();
        return result;
    }
}

class Order{
    private int id;
    private String user;
    private Date date;

    public Order() {
    }

    public Order(int id, String user, Date date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

class Pproduct{
    private int id;
    private String name;
    private int price;

    public Pproduct() {
    }

    public Pproduct(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    // 省略构造方法 和geter、seter
}