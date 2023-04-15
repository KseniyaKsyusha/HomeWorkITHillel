package ua.en.kosse.oksana.hillel.hw4;

public abstract class Animal {
    private static int animalCount;
    private String typeAnimal; // Вид
    private String nameAnimal; // Кличка
    private int distanceRun; // Дистанция бег
    private int distanceSwim; // Дистанция плавание

    public Animal() {
        animalCount++;
    }

    public Animal(String typeAnimal, String nameAnimal, int distanceRun) {
        this.typeAnimal = typeAnimal;
        this.nameAnimal = nameAnimal;
        this.distanceRun = distanceRun;
        animalCount++;
    }

    public Animal(String typeAnimal, String nameAnimal, int distanceRun, int distanceSwim) {
        this.typeAnimal = typeAnimal;
        this.nameAnimal = nameAnimal;
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        animalCount++;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public int getDistanceSwim() {
        return distanceSwim;
    }

    public abstract void runAbstract(int distanceRun);
    public abstract void swimAbstract(int distanceSwim);
}
