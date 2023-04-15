package ua.en.kosse.oksana.hillel.hw6.star;

import java.util.Random;

public class RandomWords {
    Random rand = new Random();

    public String randomWords(String[] words) {
        int i = rand.nextInt(words.length);
        return words[i];
    }
}
