package ua.en.kosse.oksana.hillel.hw23.builder.carComposition;

import ua.en.kosse.oksana.hillel.hw23.builder.enums.TransmissionType;

public class Transmission {

    private TransmissionType type;
    private int numOfGears;

    public Transmission(TransmissionType type, int numOfGears) {
        this.type = type;
        this.numOfGears = numOfGears;
    }

    public Transmission(TransmissionType type) {
        this.type = type;
    }

    public TransmissionType getType() {
        return type;
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    @Override
    public String toString() {
        return "\nTransmission type: " + type +
                "\nNumber of gears: " + numOfGears;
    }
}

