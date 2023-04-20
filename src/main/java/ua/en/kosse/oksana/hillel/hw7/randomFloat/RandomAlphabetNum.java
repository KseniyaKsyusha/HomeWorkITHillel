package ua.en.kosse.oksana.hillel.hw7.randomFloat;

import java.util.Random;

public class RandomAlphabetNum {
    public char getRandomAlphabetNum(){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }
}
