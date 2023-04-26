package ua.en.kosse.oksana.hillel.hw8.figure;

public class Triangle implements AreaFigure {
    private int sideA;
    private int sideB;
    private int sideC; //  сторони трикутника

    public Triangle(int sideA, int sideB, int sideC) {
        String flag = "";
        if (sideA + sideB <= sideC) {
            flag = "sideC";
        } else if (sideA + sideC <= sideB) {
            flag = "sideB";
        } else if (sideB + sideC <= sideA) {
            flag = "sideA";
        }
        if (!flag.equals("")) {
            throw new IllegalArgumentException("Triangle does not exist " + flag + " > sums of other");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }



    @Override
    public double getArea() {
        double p = (double) (sideA + sideB + sideC)/ 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}

