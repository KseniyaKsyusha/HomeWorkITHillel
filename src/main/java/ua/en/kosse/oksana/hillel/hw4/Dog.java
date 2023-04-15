package ua.en.kosse.oksana.hillel.hw4;

public class Dog extends Animal implements Play {
    private static int dogCount;

    public Dog() {
        dogCount++;
    }

    public Dog(String typeAnimal, String nameAnimal, int distanceRun, int distanceSwim) {
        super(typeAnimal, nameAnimal, distanceRun, distanceSwim);
        if (distanceRun > 500) {
            throw new IllegalArgumentException("The length of the dog run exceeds 500 m");
        }
        if (distanceSwim > 10) {
            throw new IllegalArgumentException("The length of the dog's swimming distance exceeds 10 m");
        }
        dogCount++;
    }


    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run() {
        System.out.printf("%s   %s  running  %s m. \n",
                getTypeAnimal(), getNameAnimal(), getDistanceRun());
    }

    @Override
    public void swim() {
        System.out.printf("%s   %s swim  %s m. \n",
                getTypeAnimal(), getNameAnimal(), getDistanceSwim());
    }

    @Override
    public void runAbstract(int distanceRun) {
        if (distanceRun > 500) {
            throw new IllegalArgumentException("The length of the dog run exceeds 500 m");
        }
        System.out.printf("%s   %s  running  %s m. \n",
                getTypeAnimal(), getNameAnimal(), distanceRun);
    }

    @Override
    public void swimAbstract(int distanceSwim) {
        if (distanceSwim > 10) {
            throw new IllegalArgumentException("The length of the dog's swimming distance exceeds 10 m");
        }
        System.out.printf("%s   %s swim  %s m. \n",
                getTypeAnimal(), getNameAnimal(), distanceSwim);
    }
}
