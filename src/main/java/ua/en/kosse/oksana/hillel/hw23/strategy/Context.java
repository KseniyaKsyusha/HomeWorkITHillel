package ua.en.kosse.oksana.hillel.hw23.strategy;

public class Context {
    private SquareStrategy strategy;

    public Context() {
    }

    public void setStrategy(SquareStrategy strategy) {
        this.strategy = strategy;
    }

    public double squareByStrategy(double a, double b) {
        return strategy.square(a, b);
    }
}
