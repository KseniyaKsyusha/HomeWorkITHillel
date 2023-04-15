package ua.en.kosse.oksana.hillel.hw4.animalRandom;

import ua.en.kosse.oksana.hillel.hw4.Animal;

import java.util.Random;

public class RandomAnimal implements AnimalRandom {
    AnimalRandom[] generateAnimal; // инициализируем массив
    Random rand = new Random();

    public RandomAnimal(AnimalRandom[] generateAnimal) {
        this.generateAnimal = generateAnimal;
    }

    @Override
    public Animal createAnimal() {
        int  i = rand.nextInt(generateAnimal.length); // массив будет состоят из 2ух обьектов
                                                      // выбираем какой выбрать элемент массива Cat or Dog
        return generateAnimal[i].createAnimal();
    }
}
