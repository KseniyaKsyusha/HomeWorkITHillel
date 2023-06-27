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
    private static List<Product> myProduct;

    public static void main(String[] args) {
        productList = productDate();
        //5.2 Реалізувати метод калькуляції загальної вартості продуктів, які відповідають наступним критеріям:
        //- продукт додано протягом поточного року
        //- продукт має тип “Book”
        //- ціна продукту не перевищує 75
        printProduct(productList);
        System.out.println("----------------------------");
        takeProduct(productList, BOOK).forEach(System.out::println);
        System.out.printf("BOOK: %s", takeProductReduce());
    }

    public static List<Product> takeProduct(List<Product> products, TypeProduct type) {
         myProduct = products.stream().filter(booking -> booking.getType().equals(type) &&
                booking.getDateShop().getYear() == LocalDate.now().getYear() && booking.getPrices() < 75).
                collect(Collectors.toList());
        return myProduct;
    }

    public static Integer takeProductReduce() {
        return myProduct.stream().reduce(0,(x,y)->x + y.getPrices(),Integer::sum);
    }
}





