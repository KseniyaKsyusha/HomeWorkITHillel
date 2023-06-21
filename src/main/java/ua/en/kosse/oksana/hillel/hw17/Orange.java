package ua.en.kosse.oksana.hillel.hw17;

public class Orange implements Fruit {
    private final float weight = 1.5F;
    private String orangeVariety;


    public Orange(String orangeVariety) {
        this.orangeVariety = orangeVariety;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "orangeVariety='" + orangeVariety + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
