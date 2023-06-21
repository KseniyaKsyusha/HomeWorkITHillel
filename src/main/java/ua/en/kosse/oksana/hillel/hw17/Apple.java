package ua.en.kosse.oksana.hillel.hw17;

public class Apple implements Fruit {
    private final float weight = 1.0F;
    private String appleVariety;


    public Apple(String appleVariety) {
        this.appleVariety = appleVariety;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleVariety='" + appleVariety + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
