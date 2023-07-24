package ua.en.kosse.oksana.hillel.hw23.builder;

import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Body;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Engine;
import ua.en.kosse.oksana.hillel.hw23.builder.carComposition.Transmission;

public interface Builder {
    void setCarBody(Body body);

    void setCarEngine(Engine engine);

    void setCarTransmission(Transmission transmission);
}
