package ua.en.kosse.oksana.hillel.hw4.animalRandom;

import ua.en.kosse.oksana.hillel.hw4.Animal;
import ua.en.kosse.oksana.hillel.hw4.Cat;

public class CatRandom implements AnimalRandom {

    @Override
    public Animal createAnimal() {
        return new Cat(); //создаем обьект Cat
    }
}
