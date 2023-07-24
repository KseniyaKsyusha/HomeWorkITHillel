package ua.en.kosse.oksana.hillel.hw23.builder;

import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Body;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Engine;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Transmission;

public class Car {
    private final Body body;
    private final Engine engine;
    private final Transmission transmission;

    public Car(Body body, Engine engine, Transmission transmission) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public Body getBody() {
        return body;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        String result = "car has" + body + engine;
        if (transmission.toString().isBlank()) {
            return result + "\n";
        } else {
            return result + transmission + "\n";
        }
    }
}
