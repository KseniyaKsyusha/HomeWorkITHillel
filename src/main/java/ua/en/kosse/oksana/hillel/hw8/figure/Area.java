package ua.en.kosse.oksana.hillel.hw8.figure;

public class Area {

    public double area(AreaFigure[] figure) {
        double summaArea = 0;
        for (int i = 0; i < 3; i++) {
            /*if(figure[i] == null){
                throw new NullPointerException();
            } else{
                summaArea += figure[i].getArea();
                System.out.println(figure[i].toString());
                System.out.println("Figure " + figure[i].getName() + " : area => " + String.format("%.5f", figure[i].getArea()));
                System.out.println();
            }*/
            try {
                summaArea += figure[i].getArea();
                System.out.println(figure[i].toString());
                System.out.println("Figure " + figure[i].getName() + " : area => " + String.format("%.5f", figure[i].getArea()));
                System.out.println();
            } catch (NullPointerException e) {
                System.err.println("Figure is null =>" + e.getMessage());
            }


        }
        return summaArea;

    }

}
