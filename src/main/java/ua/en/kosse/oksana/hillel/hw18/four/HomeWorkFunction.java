package ua.en.kosse.oksana.hillel.hw18.four;

import ua.en.kosse.oksana.hillel.hw18.one.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ua.en.kosse.oksana.hillel.hw18.four.ProductDate.productDate;


public class HomeWorkFunction {
    private static List<Product> productList;

    public static void main(String[] args) {
        productList = productDate();
        //4.2 Реалізувати метод отримання трьох останніх доданих продуктів
        printProduct(productList);
        System.out.println("----------------------------");
        takeProduct(productList).forEach(System.out::println);
        System.out.println("----------------------------");
        takeProductLimit(productList).forEach(System.out::println);

    }

    public static List<Product> takeProduct(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getDateShop)).
                skip(products.size() - 3).
                collect(Collectors.toList());
    }

    public static List<Product> takeProductLimit(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getDateShop).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void printProduct(List<Product> products) {
        products.stream().sorted(Comparator.comparing(Product::getDateShop)).
                forEach(System.out::println);
    }
}




