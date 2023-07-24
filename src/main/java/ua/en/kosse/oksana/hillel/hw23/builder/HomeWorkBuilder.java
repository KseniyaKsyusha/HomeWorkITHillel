package ua.en.kosse.oksana.hillel.hw23.builder;

public class HomeWorkBuilder {
    public static void main(String[] args) {

        Creator creator = new Creator();

        CarBuilder builder = new CarBuilder();

        Car sportCar = creator.patternSportCar(builder);

        System.out.println("sport " + sportCar);

        Car carForFamily = creator.patternFamilyCar(builder);
        System.out.println("family " + carForFamily);

    }
}
