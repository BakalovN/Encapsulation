package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private ArrayList<Product> products;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product){
        if (product.getCost()<=money){
            products.add(product);
            money = money - product.getCost();

            System.out.printf("%s bought %s%n", this.name, product.getName());
        }else {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
