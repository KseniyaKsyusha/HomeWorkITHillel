package ua.en.kosse.oksana.hillel.hw14;

import com.github.javafaker.Faker;

public class HomeWorkQueue {

    public static void main(String[] args) {
        Faker faker=new Faker();
        CoffeeOrderBoard myCoffeeOrderBoard = new CoffeeOrderBoard();
        for (int i = 1; i < 10; i++) {
            myCoffeeOrderBoard.add(i, faker.name().fullName());
        }
        System.out.println("3.");
        System.out.println(myCoffeeOrderBoard);

        //4. Реалізувати метод deliver у класі CoffeeOrderBoard. Цей метод видає найближче
        // у черзі замовлення. Видача супроводжується видаленням замовлення зі списку.
        System.out.println("4.");
        System.out.println(myCoffeeOrderBoard.deliver());
        System.out.println(myCoffeeOrderBoard);

        //5. Реалізувати метод deliver у класі CoffeeOrderBoard. Даний метод видає замовлення
        // з певним номером. Видача супроводжується видаленням замовлення зі списку.
        //Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.
        System.out.println("5.");
        myCoffeeOrderBoard.deliver(5);
        System.out.println(myCoffeeOrderBoard);

        // 6. Реалізувати метод draw у класі CoffeeOrderBoard.
        // Цей метод виводить у консоль інформацію про поточний стан черги
        // у порядку найближчого до видачі замовлення.
        System.out.println("6.");
        myCoffeeOrderBoard.draw();
    }
}

