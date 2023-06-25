package ua.en.kosse.oksana.hillel.hw18.six;

import ua.en.kosse.oksana.hillel.hw18.one.Product;
import ua.en.kosse.oksana.hillel.hw18.one.TypeProduct;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static ua.en.kosse.oksana.hillel.hw18.four.HomeWorkFunction.printProduct;
import static ua.en.kosse.oksana.hillel.hw18.six.ProductId.productId;


public class HomeWorkFunction {
    private static List<Product> productList;

    public static void main(String[] args) {
        productList = productId();
        //** 6.2 Реалізувати метод групування об'єктів за типом продукту.
        // Таким чином результатом виконання методу
        //буде тип даних “Словник”, що зберігає пару ключ-значення: {тип: список_продуктів}
        printProduct(productList);
        System.out.println("----------------------------");
        getMapProductsWithTypeKey().forEach((productType, products) -> {
            System.out.println(productType);
            products.forEach(System.out::println);
        });
    }

    public static Map<TypeProduct, List<Product>> getMapProductsWithTypeKey() {
        return productList.stream().collect(groupingBy(Product::getType));
    }
}




