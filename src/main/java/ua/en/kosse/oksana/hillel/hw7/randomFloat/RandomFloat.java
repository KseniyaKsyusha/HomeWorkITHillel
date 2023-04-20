package ua.en.kosse.oksana.hillel.hw7.randomFloat;

import java.util.Random;

public class RandomFloat {
    public float getRandomNumberFloat(float min, float max) {
        Random random = new Random();
        return random.nextFloat(max - min) + min;
    }
}
