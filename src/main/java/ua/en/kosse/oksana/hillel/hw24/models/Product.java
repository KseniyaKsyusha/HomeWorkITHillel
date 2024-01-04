package ua.en.kosse.oksana.hillel.hw24.models;

public class Product {
    private Integer id;

    private String name;

    private Integer price;

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product name: " + name +", price: " + price;
    }
}
