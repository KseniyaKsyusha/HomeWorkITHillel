package ua.en.kosse.oksana.hillel.hw18.four;

import ua.en.kosse.oksana.hillel.hw18.one.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.BOOK;
import static ua.en.kosse.oksana.hillel.hw18.one.TypeProduct.PERFUME;

public class ProductDate {

    public static List<Product> productDate() {
        ArrayList<Product> myProductArrayList = new ArrayList<>();
        Product product1 = new Product(BOOK, 2390,true, LocalDate.of(2023,2,1));
        myProductArrayList.add(product1);
        myProductArrayList.add(new Product(BOOK, 23,true, LocalDate.of(2023,12,6)));
        myProductArrayList.add(new Product(PERFUME, 2600,false,LocalDate.of(2022,2,1)));
        myProductArrayList.add(new Product(BOOK, 300,true,LocalDate.of(2023,4,7)));
        myProductArrayList.add(new Product(PERFUME, 2300,false,LocalDate.of(2023,12,11)));
        myProductArrayList.add(new Product(PERFUME, 23,true,LocalDate.of(2023,9,3)));
        myProductArrayList.add(new Product(BOOK, 250,true,LocalDate.of(2022,2,1)));
        myProductArrayList.add(new Product(BOOK, 251,false,LocalDate.of(2023,4,18)));
        return myProductArrayList;
    }
}
