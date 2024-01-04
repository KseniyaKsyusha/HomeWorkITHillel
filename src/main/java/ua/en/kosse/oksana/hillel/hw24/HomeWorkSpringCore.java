package ua.en.kosse.oksana.hillel.hw24;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.en.kosse.oksana.hillel.hw24.models.Cart;
import ua.en.kosse.oksana.hillel.hw24.utils.Utils;


import java.util.Scanner;

public class HomeWorkSpringCore {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ua.en.kosse.oksana.hillel.hw24.models");

        Scanner scanner = new Scanner(System.in);
        Cart cart = context.getBean(Cart.class);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1 - add product, 2 - remove product, 3 - new cart, 4 - exit");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("\nEnter product ID to add:");
                    Utils.printProductInfo(context);
                    int selectedProduct = scanner.nextInt();
                    if (Utils.enterAndCheckID(selectedProduct, context)) {
                        cart.addProductToChart(selectedProduct);
                    }
                    cart.getAll();
                }
                case 2 -> {
                    cart.getAll();
                    System.out.println("\nEnter product ID to remove:");
                    Utils.printProductInfo(context);

                    int selectedProduct = scanner.nextInt();

                    if (Utils.enterAndCheckID(selectedProduct, context)) {
                        cart.removeProduct(selectedProduct);
                    }
                    cart.getAll();
                }
                case 3 -> {
                    System.out.println("new cart is created");
                    cart = context.getBean(Cart.class);
                    cart.getAll();
                }
                case 4 -> isExit = true;
            }
        }
        scanner.close();
    }

}

