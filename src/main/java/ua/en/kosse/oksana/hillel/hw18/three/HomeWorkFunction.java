package ua.en.kosse.oksana.hillel.hw18.three;

import ua.en.kosse.oksana.hillel.hw18.one.Product;
import ua.en.kosse.oksana.hillel.hw18.one.TypeProduct;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static ua.en.kosse.oksana.hillel.hw18.one.HomeWorkFunction.printBook;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;
import static ua.en.kosse.oksana.hillel.hw18.two.ProductDiscount.productBooks;

public class HomeWorkFunction {
    private static List<Product> productList;

    public static void main(String[] args) {
        productList = productBooks();
        //3.2 Реалізувати метод отримання найдешевшого продукту з категорії “Book”
        //3.3 У випадку, якщо жоден продукт не знайдено (ситуація, коли немає продукту з категорією),
        // викинути виняток з повідомленням “Продукт [категорія: ім'я_категорії] не знайдено”.
        printBook(productList);
        System.out.println("----------------------------");
        takeProduct(productList, BOOK);
        System.out.println("-----------------------------");
        System.out.println(takeProductFun(productList, BOOK));
    }

    public static void takeProduct(List<Product> products, TypeProduct type) {

        try {
            Product min = products.stream().filter(booking -> booking.getType().equals(type)).
                    min(Product::compareTo).orElseThrow(Exception::new);
            System.out.println(min.getType() + ": min price => " + min.getPrices());
        } catch (Exception e) {
            System.out.println("Product [Category" + type + "] not found]");
        }

    }

    public static Product takeProductFun(List<Product> products, TypeProduct type) {
        return products.stream().filter(booking -> booking.getType().equals(type)).
                min(Comparator.comparing(Product::getPrices)).
                orElseThrow();
    }

}
