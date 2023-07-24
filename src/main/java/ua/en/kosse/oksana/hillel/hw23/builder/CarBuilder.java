package ua.en.kosse.oksana.hillel.hw23.builder;

import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Body;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Engine;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Transmission;

public class CarBuilder implements Builder{
    private Body body;
    private Engine engine;
    private Transmission transmission;

    @Override
    public void setCarBody(Body body) {
        this.body=body;
    }

    @Override
    public void setCarEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setCarTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Car buildCar(){
        return new Car (body, engine, transmission);
    }
}
