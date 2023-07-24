package ua.en.kosse.oksana.hillel.hw23.strategy.figure;

import ua.en.kosse.oksana.hillel.hw23.strategy.SquareStrategy;

public class SquareTriangle implements SquareStrategy {
    @Override
    public double square(double height, double side) {
        return height*side*1/2;
    }
}
