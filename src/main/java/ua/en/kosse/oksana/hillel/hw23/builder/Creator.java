package ua.en.kosse.oksana.hillel.hw23.builder;

import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Body;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Engine;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Transmission;
import ua.en.kosse.oksana.hillel.hw23.builder.enums.BodyType;
import ua.en.kosse.oksana.hillel.hw23.builder.enums.EngineType;
import ua.en.kosse.oksana.hillel.hw23.builder.enums.TransmissionType;

public class Creator {
    public Car patternSportCar(CarBuilder builder){
        builder.setCarBody(new Body(BodyType.CABRIOLET, 3));
        builder.setCarEngine(new Engine(3, EngineType.PETROL));
        builder.setCarTransmission(new Transmission(TransmissionType.MANUAL, 5));
        return builder.buildCar();
    }

    public Car patternFamilyCar(CarBuilder builder){
        builder.setCarBody(new Body(BodyType.SEDAN, 4));
        builder.setCarEngine(new Engine(2, EngineType.DIESEL));
        builder.setCarTransmission(new Transmission(TransmissionType.AUTOMATIC, 6));
        return builder.buildCar();
    }
}
