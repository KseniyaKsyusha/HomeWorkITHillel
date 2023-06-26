package ua.en.kosse.oksana.hillel.hw18.five;

import ua.en.kosse.oksana.hillel.hw18.one.Product;
import ua.en.kosse.oksana.hillel.hw18.one.TypeProduct;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ua.en.kosse.oksana.hillel.hw18.four.HomeWorkFunction.printProduct;
import static ua.en.kosse.oksana.hillel.hw18.four.ProductDate.productDate;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;


public class HomeWorkFunction {
    private static List<Product> productList;

    public static void main(String[] args) {
        productList = productDate();
        //5.2 Реалізувати метод калькуляції загальної вартості продуктів, які відповідають наступним критеріям:
        //- продукт додано протягом поточного року
        //- продукт має тип “Book”
        //- ціна продукту не перевищує 75
        printProduct(productList);
        System.out.println("----------------------------");
        takeProduct(productList, BOOK).forEach(System.out::println);
        System.out.printf("BOOK: %s", takeProductReduce(productList, BOOK));
    }

    public static List<Product> takeProduct(List<Product> products, TypeProduct type) {
        return products.stream().filter(booking -> booking.getType().equals(type)).
                filter(booking -> booking.getDateShop().getYear() == LocalDate.now().getYear()).
                filter(booking -> booking.getPrices() < 75).collect(Collectors.toList());

    }

    public static Integer takeProductReduce(List<Product> products, TypeProduct type) {
        List<Product> myProduct = products.stream().filter(booking -> booking.getType().equals(type)).
                filter(booking -> booking.getDateShop().getYear() == LocalDate.now().getYear()).
                filter(booking -> booking.getPrices() < 75).collect(Collectors.toList());
        return myProduct.stream().reduce(0,(x,y)->x + y.getPrices(),Integer::sum);
    }
}





