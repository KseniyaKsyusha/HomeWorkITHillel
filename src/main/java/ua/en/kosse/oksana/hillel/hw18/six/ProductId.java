package ua.en.kosse.oksana.hillel.hw18.six;

import ua.en.kosse.oksana.hillel.hw18.one.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.PERFUME;

public class ProductId {

    public static List<Product> productId() {
        ArrayList<Product> myProductArrayList = new ArrayList<>();
        Product product1 = new Product(1,BOOK, 2390,true, LocalDate.of(2023,2,1));
        myProductArrayList.add(product1);
        myProductArrayList.add(new Product(2,BOOK, 23,true, LocalDate.of(2023,12,6)));
        myProductArrayList.add(new Product(3,PERFUME, 2600,false,LocalDate.of(2022,2,1)));
        myProductArrayList.add(new Product(4,BOOK, 300,true,LocalDate.of(2023,4,7)));
        myProductArrayList.add(new Product(5,PERFUME, 2300,false,LocalDate.of(2023,12,11)));
        myProductArrayList.add(new Product(6,PERFUME, 23,true,LocalDate.of(2023,9,3)));
        myProductArrayList.add(new Product(7,BOOK, 250,true,LocalDate.of(2022,2,1)));
        myProductArrayList.add(new Product(8,BOOK, 251,false,LocalDate.of(2023,4,18)));
        return myProductArrayList;
    }
}
