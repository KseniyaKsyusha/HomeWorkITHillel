package ua.en.kosse.oksana.hillel.hw18.four;

import ua.en.kosse.oksana.hillel.hw18.one.Product;
import ua.en.kosse.oksana.hillel.hw18.one.TypeProduct;

import java.util.Comparator;
import java.util.List;

import static ua.en.kosse.oksana.hillel.hw18.four.ProductDate.productDate;
import static ua.en.kosse.oksana.hillel.hw18.one.HomeWorkFunction.printBook;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;


public class HomeWorkFunction {
    private static List<Product> productList;

    public static void main(String[] args) {
        productList = productDate();
        //4.2 Реалізувати метод отримання трьох останніх доданих продуктів
        printProduct(productList);
        System.out.println("----------------------------");
        takeProduct(productList);
    }

    public static void takeProduct(List<Product> products) {
        products.stream().sorted(Comparator.comparing(Product::getDateShop)).
                          skip(products.size() - 3).
                          forEach(System.out::println);
    }
    public static void printProduct(List<Product> products) {
        products.stream().sorted(Comparator.comparing(Product::getDateShop)).
                          forEach(System.out::println);
    }
}




