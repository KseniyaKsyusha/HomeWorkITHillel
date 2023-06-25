package ua.en.kosse.oksana.hillel.hw18.two;

import ua.en.kosse.oksana.hillel.hw18.one.Product;

import java.util.ArrayList;
import java.util.List;

import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.PERFUME;

public class ProductDiscount {

    public static List<Product> productBooks() {
        ArrayList<Product> myProductArrayList = new ArrayList<>();
        Product product1 = new Product(BOOK, 2390,true);
        myProductArrayList.add(product1);
        myProductArrayList.add(new Product(BOOK, 230,true));
        myProductArrayList.add(new Product(PERFUME, 2600,false));
        myProductArrayList.add(new Product(BOOK, 300,true));
        myProductArrayList.add(new Product(PERFUME, 2300,false));
        myProductArrayList.add(new Product(PERFUME, 23,true));
        myProductArrayList.add(new Product(BOOK, 250,true));
        myProductArrayList.add(new Product(BOOK, 251,false));
        return myProductArrayList;
    }
}
