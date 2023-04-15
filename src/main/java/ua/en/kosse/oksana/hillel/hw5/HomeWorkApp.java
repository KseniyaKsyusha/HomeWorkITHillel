package ua.en.kosse.oksana.hillel.hw5;

import ua.en.kosse.oksana.hillel.hw5.color.PrintColor;
import ua.en.kosse.oksana.hillel.hw5.even.EvenNumber;
import ua.en.kosse.oksana.hillel.hw5.number.Numbers;
import ua.en.kosse.oksana.hillel.hw5.number.OperationNumber;
import ua.en.kosse.oksana.hillel.hw5.number.SumSign;
import ua.en.kosse.oksana.hillel.hw5.string.ThreeWords;
import ua.en.kosse.oksana.hillel.hw5.year.LeapYear;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
        String str = "Orange, Banana, Apple";
        int valA = (int) (Math.random() * 200 - 100);
        int valB = (int) (Math.random() * 200 - 100);

        //4. Створіть метод printColor() у тілі якого задайте int змінну value та ініціалізуйте її
        // будь-яким значенням. Якщо значення менше 0 (0 включно), то в консоль метод повинен
        // вивести повідомлення "Червоний", якщо лежить в межах від 0 (0 виключно) до 100 (100 включно),
        // то "Жовтий", якщо більше 100 (100 виключно) - "Зелений";
        System.out.println("4. " + new PrintColor().printColor());
        System.out.println();

        // 6. Написати метод, який приймає на вхід два цілих числа і перевіряє,
        // що їхня сума лежить в межах від 10 до 20 (включно), якщо так – повернути true, інакше – false.
        int result = SumSign.checkSumSign(valA, valB);
        System.out.printf("6. Результат valA + valB = %s в межах від 10 до 20 (включно) повертає => %s \n",
                result, result >= 10 && result <= 20);

        // 3. Створіть метод checkSumSign(), у тілі якого оголосіть дві int змінні a і b,
        // та ініціалізуйте їх будь-якими значеннями, якими захочете.
        // Далі метод повинен підсумувати ці змінні, і якщо їх сума більша або дорівнює 0,
        // то вивести в консоль повідомлення "Сума позитивна", інакше - "Сума негативна";
        System.out.printf("3. valA = %s, valB = %s, результат => %s \n", valA, valB,
                new OperationNumber().summaSign(valA, valB));

        // 5. Створіть метод compareNumbers(), у тілі якого оголосіть дві int змінні a і b,
        // та ініціалізуйте їх будь-якими значеннями, якими захочете. Якщо a більше або одно b,
        // необхідно вивести в консоль повідомлення “a >= b”, інакше “a < b”;
        System.out.printf("5. порівняння => %s \n", new Numbers().compareNumbers(valA, valB));
        System.out.println();

        //7. Написати метод, якому як параметр передається ціле число,
        // метод повинен надрукувати в консоль, чи додатнє число передали або від’ємне.
        // Примітка: нуль вважаємо позитивним числом.
        System.out.printf("7. число %s => %s\n", valB, new EvenNumber().evenNumberString(valB));

        //8. Написати метод, якому як параметр передається ціле число.
        // Метод повинен повернути true, якщо число є негативним, і повернути false якщо позитивне.
        System.out.printf("8. число %s => %s\n", valA, new EvenNumber().evenNumberBoolean(valA));

        System.out.println();
        //2. Створіть метод printThreeWords(), який під час виклику повинен надрукувати в стовпець у три слова: Orange, Banana, Apple.
        //Orange
        //Banana
        //Apple
        new ThreeWords().printThreeWords(str);

        System.out.println();
        //9. Написати метод, якому як аргументи передається рядок і число,
        // метод повинен надрукувати в консоль зазначений рядок, вказану кількість разів;
        new ThreeWords().stringNumber(str, new Random().nextInt(10));

        System.out.println();
        //10. * Написати метод, який визначає, чи є рік високосним, і повертає boolean
        // (високосний – true, не високосний – false). Кожен 4-й рік є високосним,
        // крім кожного 100-го, причому кожен 400-й – високосний.
        new LeapYear().leapYear();


    }
}
