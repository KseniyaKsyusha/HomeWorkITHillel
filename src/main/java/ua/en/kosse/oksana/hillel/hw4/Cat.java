package ua.en.kosse.oksana.hillel.hw4;

public class Cat extends Animal implements Play {
    private static int catCount;

    public Cat() {
        catCount++;
    }

    public Cat(String typeAnimal, String nameAnimal, int distanceRun) {
        super(typeAnimal, nameAnimal, distanceRun);
        if (distanceRun > 200) {
            throw new IllegalArgumentException("The length of the cat run exceeds 200 m");
        }
        catCount++;
    }

    public static int getCatCount(){
        return catCount;
    }

    @Override
    public void run() {
        System.out.printf("%s   %s  running  %s m. \n",
               getTypeAnimal(), getNameAnimal(), getDistanceRun());
    }

    @Override
    public void swim() {
        System.out.println("Cats don't swim!!! \n");
    }

    @Override
    public void runAbstract(int distanceRun) {
        if (distanceRun > 200) {
            throw new IllegalArgumentException("The length of the cat run exceeds 200 m");
        }
        System.out.printf("%s   %s  running  %s m. \n",
                getTypeAnimal(), getNameAnimal(), distanceRun);
    }

    @Override
    public void swimAbstract(int distanceSwim) {
        System.out.println("Cats don't swim!!! \n");
    }
}
