package ua.en.kosse.oksana.hillel.hw5.color;

public class PrintColor {

    public String printColor() {
        int value = new RandomNumber().getRandomNumberInt(-200, 200);
        StringBuilder builder = new StringBuilder();
        builder.append("Результат виконання: " + value + " => ");
        if (value <= 0) {
            builder.append("\"Червоний\"");
        }
        else if (value >0 &&  value<=100) {
            builder.append(" \"Жовтий\"");
        }
        else {
            builder.append("\"Зелений\"");
        }
        return builder.toString();
    }
}
