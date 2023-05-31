package ua.en.kosse.oksana.hillel.hw12;

import com.github.javafaker.Faker;
import ua.en.kosse.oksana.hillel.hw12.occurrence.*;
import ua.en.kosse.oksana.hillel.hw5.color.RandomNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeWorkList {
    public static void main(String[] args) {

        //1. Створити метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
        // Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
        // Порахувати скільки разів зустрічається переданий рядок як другий аргумент.
        System.out.println("1: ");
        Faker faker = new Faker();
        List<String> myStringList = new ArrayList<>(Arrays.asList("Energodar", "Energodar"));

        for (int i = 0; i < 7; i++) {
            myStringList.add(faker.country().capital());
            myStringList.add("Zaporizhzhya NPP");
        }
        myStringList.add("Energodar");

        System.out.println("In the list: ");
        System.out.println(Arrays.toString(new List[]{myStringList}));

        int count = Occurrence.countOccurrence(myStringList, myStringList.get(1));
        System.out.printf("city %s occurs %s times\n", myStringList.get(1), count);
        count = Occurrence.countOccurrence(myStringList, myStringList.get(3));
        System.out.printf("%s occurs %s times\n", myStringList.get(3), count);


        //2. Створити метод toList, що приймає на вхід цілісний масив довільної довжини.
        // Конвертувати масив у список відповідного типу даних та повернути з методу.
        //Наприклад:
        //Було Array [1, 2, 3]
        //Стало List [1, 2, 3]
        System.out.println();
        System.out.println("2:");
        int[] myArray = new int[20];
        myArray[0] = 69;
        myArray[1] = 69;
        for (int i = 2; i < 16; i+=2) {
            myArray[i] = new RandomNumber().getRandomNumberInt(-200, 200);
            myArray[i+1] = 99;
        }

        System.out.println("In the list: ");
        List<Integer> myIntegerList = ArrayToList.toList(myArray);
        ArrayToList.printList(myIntegerList);

        //3. Створити метод findUnique, що приймає на вхід числовий список, що складається з довільних значень,
        // які можуть повторюватися в необмеженій кількості. Необхідно повернути новий числовий список,
        // що містить тільки унікальні числа.
        System.out.println();
        System.out.println("3: ");
        FindUnique.findUnique(myIntegerList);



        //4. ** Створити метод calcOccurance, який приймає на вхід рядковий список як параметр.
        // Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
        // Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль.
        //Наприклад:
        //bird: 2
        //fox: 1
        //cat: 1
        System.out.println();
        System.out.println("4**: ");
        System.out.println(MyCounter.of(myIntegerList));
        CalcOccurrence.calcOccurrence(myStringList);

        //4. *** Створити метод findOccurance, що приймає на вхід рядковий список як параметр.
        // Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
        // Обчислити скільки разів трапляється кожне слово.
        // Результат повернути у вигляді списку структур, що описують повторення кожного окремого взятого слова.
        //[ {name: "bird", occurrence: 2},
        //{name: "fox", occurrence: 1},
        //{name: "cat", occurrence: 1}]
        System.out.println();
        System.out.println("4***: ");
        System.out.println(FindOccurrence.findOccurrence(myStringList));
    }
}
