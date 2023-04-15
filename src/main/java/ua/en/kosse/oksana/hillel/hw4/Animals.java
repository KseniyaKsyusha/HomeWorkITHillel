package ua.en.kosse.oksana.hillel.hw4;

import com.github.javafaker.Faker;
import ua.en.kosse.oksana.hillel.hw4.animalRandom.AnimalRandom;
import ua.en.kosse.oksana.hillel.hw4.animalRandom.CatRandom;
import ua.en.kosse.oksana.hillel.hw4.animalRandom.DogRandom;
import ua.en.kosse.oksana.hillel.hw4.animalRandom.RandomAnimal;

import java.util.Random;

public class Animals {
    public static void main(String[] args) {
        Faker faker = new Faker();
        // Створити класи Собака та Кіт з успадкуванням від класу Тварини.
        // Всі тварини можуть бігти та плисти. Як параметр кожному методу передається довжина перешкоди.
        Dog dog = new Dog("Dog",faker.dog().name(), 500, 10);
        dog.run();
        dog.swim();
        System.out.println("Як параметр кожному методу передається довжина перешкоди");
        dog.runAbstract(400);
        dog.swimAbstract(5);

        System.out.println();

        Cat cat = new Cat("Cat", faker.cat().name(),150);
        cat.run();
        cat.swim();
        System.out.println("Як параметр кожному методу передається довжина перешкоди");
        cat.runAbstract(100);
        cat.swimAbstract(0);

        RandomAnimal rand = new RandomAnimal(new AnimalRandom[]{
                new CatRandom(),
                new DogRandom()
        });

        for(int i=0; i < new Random().nextInt(20); i++) {
            Animal animal = rand.createAnimal();
            System.out.println(animal.getClass().getName());

        }
        System.out.printf("Number of generated objects Cats: %s \t  Dogs: %s \t  Animals: %s \t ",
                Cat.getCatCount(), Dog.getDogCount(), Animal.getAnimalCount());
    }
}
