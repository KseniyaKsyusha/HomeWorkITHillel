package ua.en.kosse.oksana.hillel.hw18.one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.*;

public class HomeWorkFunction {

    public static void main(String[] args) {
        List<Product> productList = productBooks();
        //1.2 Реалізувати метод отримання всіх продуктів у вигляді списку,
        // категорія яких еквівалентна “Book” та ціна більш ніж 250.
        printBook(productList);
        System.out.println("-------------------------------------");
        filterBook(productList, BOOK).forEach(System.out::println) ;
    }

    public static List<Product> productBooks() {
        ArrayList<Product> myProductArrayList = new ArrayList<>();
        Product product1 = new Product(BOOK, 2390);
        myProductArrayList.add(product1);
        myProductArrayList.add(new Product(BOOK, 230));
        myProductArrayList.add(new Product(PERFUME, 2600));
        myProductArrayList.add(new Product(BOOK, 300));
        myProductArrayList.add(new Product(PERFUME, 2300));
        myProductArrayList.add(new Product(PERFUME, 23));
        myProductArrayList.add(new Product(BOOK, 250));
        myProductArrayList.add(new Product(BOOK, 251));
        return myProductArrayList;
    }

    public static List<Product> filterBook(List<Product> products, TypeProduct type) {
        return products.stream().filter(booking -> booking.getType().equals(type)).
                          filter(booking -> booking.getPrices() > 250).
                          collect(Collectors.toList());
    }

    public static void printBook(List<Product> products) {
        products.stream().forEach(System.out::println);
    }

}
