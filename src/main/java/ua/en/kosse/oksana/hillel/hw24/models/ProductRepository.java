package ua.en.kosse.oksana.hillel.hw24.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> productsInStock = new ArrayList<>();

    public ProductRepository() {
        productsInStock.add(new Product(1, "Apple", 2));
        productsInStock.add(new Product(2, "Orange", 5));
        productsInStock.add(new Product(3, "Grape", 7));
        productsInStock.add(new Product(4, "Carrot", 1));
        productsInStock.add(new Product(5, "Lemon", 3));
    }

    public Product getProductByID(Integer id) {
        if (id <= productsInStock.size()) {
            return productsInStock.get(id - 1);
        } else return null;
    }

    public List<Product> getProductsInStock() {
        return productsInStock;
    }
}
