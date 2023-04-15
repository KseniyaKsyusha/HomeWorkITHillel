package ua.en.kosse.oksana.hillel.hw4.animalRandom;

import ua.en.kosse.oksana.hillel.hw4.Animal;
import ua.en.kosse.oksana.hillel.hw4.Dog;

public class DogRandom implements AnimalRandom{

    @Override
    public Animal createAnimal() {
        return  new Dog( ); // создаем обьект собака
    }
}
