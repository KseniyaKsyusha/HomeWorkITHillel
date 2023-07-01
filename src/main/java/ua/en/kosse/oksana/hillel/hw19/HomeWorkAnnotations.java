package ua.en.kosse.oksana.hillel.hw19;

import ua.en.kosse.oksana.hillel.hw19.classtest.ClassTest;
import ua.en.kosse.oksana.hillel.hw19.classtest.ClassTest1;

import java.lang.reflect.InvocationTargetException;


public class HomeWorkAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        ClassTest class01 = new ClassTest();
        ClassTest1 class02 = new ClassTest1();

        TestRunner.start(class01);
       // TestRunner.start(class02);
    }
}
