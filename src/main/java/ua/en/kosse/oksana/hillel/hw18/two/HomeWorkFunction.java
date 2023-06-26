package ua.en.kosse.oksana.hillel.hw18.two;

import ua.en.kosse.oksana.hillel.hw18.one.Product;
import ua.en.kosse.oksana.hillel.hw18.one.TypeProduct;

import java.util.List;
import java.util.stream.Collectors;

import static ua.en.kosse.oksana.hillel.hw18.one.HomeWorkFunction.printBook;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;
import static ua.en.kosse.oksana.hillel.hw18.two.ProductDiscount.productBooks;

public class HomeWorkFunction {

    public static void main(String[] args) {
        List<Product> productList = productBooks();
        //2.2 Реалізувати метод отримання всіх продуктів як списку,
        // категорія яких еквівалентна “Book” і з можливістю застосування знижки.
        // Фінальний список повинен містити продукти з застосованою знижкою 10%.
        printBook(productList);
        System.out.println("---------------------");
        buyProduct(productList, 10, BOOK).forEach(System.out::println);
    }

    public static List<String> buyProduct(List<Product> products, int discount, TypeProduct type) {
        return products.stream().filter(booking -> booking.getType().equals(type))
                .map(booking -> booking.getType() + " : " + booking.getPrices() + " => discount price = " +
                        (booking.getPrices() - booking.getPrices() * discount / 100))
                .collect(Collectors.toList());

    }
}
