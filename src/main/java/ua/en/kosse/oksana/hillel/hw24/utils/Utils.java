package ua.en.kosse.oksana.hillel.hw24.utils;

import ua.en.kosse.oksana.hillel.hw24.models.Product;
import ua.en.kosse.oksana.hillel.hw24.models.ProductRepository;
import org.springframework.context.ApplicationContext;

public class Utils {
    public static void printProductInfo(ApplicationContext context) {
        for (Product p : context.getBean(ProductRepository.class).getProductsInStock()) {
            System.out.print(p.getName() + " - " + p.getId() + "\t");
        }
    }

    public static boolean enterAndCheckID(int selectedProduct, ApplicationContext context) {
        boolean isChecked = false;
        int maxId = context.getBean(ProductRepository.class).getProductsInStock().size() + 1;
        if (selectedProduct > 0 & selectedProduct <= maxId) {
            isChecked = true;
        }
        return isChecked;
    }

}
