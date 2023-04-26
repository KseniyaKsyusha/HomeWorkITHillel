package ua.en.kosse.oksana.hillel.hw8.figure;

public class Circle implements AreaFigure {

    private int radius;

    public Circle(int radius) {
        if (radius <=0) {
          throw new IllegalArgumentException("The radius cannot be less than or equal to zero.");
        }
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        //return Math.PI * radius * radius;
        return PI * radius * radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
