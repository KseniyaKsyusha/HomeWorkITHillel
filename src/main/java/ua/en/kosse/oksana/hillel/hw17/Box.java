package ua.en.kosse.oksana.hillel.hw17;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    List<T> fruitBox = new ArrayList<>();

    public void add (T fruit){
        this.fruitBox.add(fruit);
    }

    public List<T> getFruitBox() {
        return fruitBox;
    }

    public void addFruits(List<T> fruits) {
        this.fruitBox.addAll(fruits);
    }

    public float getWeight() {
        return fruitBox.size() * fruitBox.get(0).getWeight();
    }

    public <V extends Fruit> boolean compare(Box<V> compareBox) {
        return this.getWeight() == compareBox.getWeight();
    }

    public void merge(Box<T> newBox) {
        fruitBox.addAll(newBox.getFruitBox());
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitBox=" + fruitBox +
                '}';
    }
}
