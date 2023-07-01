package ua.en.kosse.oksana.hillel.hw19.classtest;

import ua.en.kosse.oksana.hillel.hw19.annotations.AfterSuite;
import ua.en.kosse.oksana.hillel.hw19.annotations.BeforeSuite;
import ua.en.kosse.oksana.hillel.hw19.annotations.Test;

//3. З «класу-тесту» спочатку має бути запущений метод з анотацією @BeforeSuite,
// якщо така є, далі запущені методи з анотаціями @Test, а по завершенню всіх тестів
// - метод з анотацією @AfterSuite.
//4. До кожного методу-тесту необхідно також додати пріоритети (int числа від 1 до 10),
// відповідно до яких вибиратиметься порядок їх виконання, якщо пріоритет однаковий, то порядок не має значення.
//6. У “методах-тестах” виконати виведення у консоль довільного значення,
// для ідентифікації дійсності виконання цього методу.

public class ClassTest1 {
    @BeforeSuite
    public void init(){
        System.out.println("BeforeSuite - start");
    }


    @Test(numberInQueue = 2)
    public void test1(){
        System.out.println("Test 1");
        int numberInQueue = 2;
        System.out.println("print from @Test numberInQueue = " + numberInQueue);
    }


    @Test(numberInQueue = 2)
    public void test2(){
        System.out.println("Test 2");
        int numberInQueue = 2;
        System.out.println("print from @Test numberInQueue = " + numberInQueue);
        throw new RuntimeException();
    }

    @Test(numberInQueue = 1)
    public void test3(){
        System.out.println("Test 3");
        int numberInQueue = 1;
        System.out.println("print from @Test numberInQueue = " + numberInQueue);

    }

    @Test(numberInQueue = 3)
    public void test4(){
        System.out.println("Test 4");
        int numberInQueue = 3;
        System.out.println("print from @Test numberInQueue = " + numberInQueue);
    }


    @AfterSuite
    public void finish(){
        System.out.println("AfterSuite - finish");
    }

    @AfterSuite
    public void finish2(){
        System.out.println("AfterSuite - finish2");
    }
}
