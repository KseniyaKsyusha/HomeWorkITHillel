package ua.en.kosse.oksana.hillel.hw23.strategy.figure;

import ua.en.kosse.oksana.hillel.hw23.strategy.SquareStrategy;

public class SquareRectangle implements SquareStrategy {
    @Override
    public double square(double sideA, double sideB) {
        return sideA*sideB;
    }
}
