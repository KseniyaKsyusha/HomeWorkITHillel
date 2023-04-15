package ua.en.kosse.oksana.hillel.hw6;

import ua.en.kosse.oksana.hillel.hw6.firstPart.first;
import ua.en.kosse.oksana.hillel.hw6.star.GuessWord;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ua.en.kosse.oksana.hillel.hw6.star.GuessWord.getStr;


public class HomeWorkString {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        final String string = "Orange, Banana, Apple";
        final String polindr = "1234554321";
        final char ch = 'a';
        final String target = "anan";
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};

        // 2. Створити метод findSymbolOccurance. Метод приймає як параметр рядок і символ.
        // Необхідно обчислити, скільки разів символ зустрічається в переданому рядку і повернути це числове значення.
        System.out.printf("2. The character \" %s \" is repeated %s times in a string \" %s \" \n",
                ch, first.findSymbolOccurance(string, ch), string);

        // 3. Створити метод findWordPosition. Метод приймає як параметри два рядки (source, target).
        // Необхідно з'ясувати, чи є target (підрядок) частиною рядка source.
        // Якщо так, тоді повернути номер позиції (індекс) першого елемента підрядка у рядку, інакше повернути -1.
        System.out.printf("3. Position number %s of the first substring element in the line \"%s\" \n"
                , first.findWordPosition(string, target), string);

        //4. Створити метод stringReverse. Метод приймає як параметр - рядок.
        // Необхідно її розгорнути та повернути змінений
        System.out.printf("4. String reverse \"%s\"\n", first.stringReverse(string));

        //5. Створити метод isPalindrome. Метод приймає як параметр - рядок.
        // Необхідно Перевірити, чи є переданий рядок паліндромом. Якщо так, тоді повернуть true, інакше false.
        System.out.printf("isPalindrome %s => %s\n", polindr, first.isPalindrome(polindr));

        System.out.println();
        //6. * Створити масив зі слів String[] words = {"apple", "orange", "lemon", "banana", "apricot",
        //        "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
        //        "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper",
        //        "pineapple", "pumpkin", "potato"};
        //При запуску програми комп'ютер загадує слово, запитує відповідь у користувача,
        //порівнює його із загаданим словом та повідомляє чи правильно відповів користувач. Якщо слово не вгадано,
        //комп'ютер показує літери, які стоять на своїх місцях.
        System.out.println("The computer guessed a word from an array:");
        System.out.println(Arrays.toString(words));
        System.out.printf("");
        String strInput = getStr();
        new GuessWord().guessWord(words,strInput);
    }



}