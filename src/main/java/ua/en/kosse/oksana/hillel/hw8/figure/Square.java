package ua.en.kosse.oksana.hillel.hw8.figure;

public class Square implements AreaFigure {

    private int sideA;

    public Square(int sideA) {
        if (sideA <= 0) {
            throw new IllegalArgumentException("The side cannot be less than or equal to zero.");
        }
        this.sideA = sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    @Override
    public double getArea() {
        return sideA * sideA;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideA=" + sideA +
                '}';
    }
}
