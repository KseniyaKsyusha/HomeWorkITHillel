package ua.en.kosse.oksana.hillel.hw23.strategy;

import ua.en.kosse.oksana.hillel.hw23.strategy.figure.SquareRectangle;
import ua.en.kosse.oksana.hillel.hw23.strategy.figure.SquareTriangle;

public class HomeWorkStrategy {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new SquareRectangle());
        double rectangle = context.squareByStrategy(4, 9.4);
        System.out.println("Area of a rectangle: "+rectangle);

        context.setStrategy(new SquareTriangle());
        double triangle = context.squareByStrategy(6,8);
        System.out.println("Area of a tiangle: "+triangle);
    }
}
