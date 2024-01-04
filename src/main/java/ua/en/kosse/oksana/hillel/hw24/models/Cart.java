package ua.en.kosse.oksana.hillel.hw24.models;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Scope("prototype")
public class Cart {
    private List<Product> productsInCart = new ArrayList<>();

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("ua.en.kosse.oksana.hillel.hw24.models");


    public void getAll() {
        if (productsInCart.isEmpty()) {
            System.out.println("Cart is empty\n");
        } else {
            System.out.println("Products in cart:");
            for (Product p : productsInCart) {
                System.out.println(p.toString());
            }
            int totalAmount = 0;
            for (Product p : productsInCart) {
                totalAmount += p.getPrice();
            }
            System.out.println("The Cost of all products in cart: " + totalAmount);
        }
    }

    public void addProductToChart(Integer id) {
        productsInCart.add(context.getBean(ProductRepository.class).getProductByID(id));
    }

    public void removeProduct(Integer id) {
        productsInCart.remove(context.getBean(ProductRepository.class).getProductByID(id));
    }
}
