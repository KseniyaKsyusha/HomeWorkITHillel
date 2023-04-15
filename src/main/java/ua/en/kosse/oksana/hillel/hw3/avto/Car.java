package ua.en.kosse.oksana.hillel.hw3.avto;

import ua.en.kosse.oksana.hillel.hw3.Employee;

public class Car {
    private String carBrand;
    private String carClass;
    private double weight;
    private Employee empl;


    public Car(String carBrand, String carClass, double weight, Employee empl) {
        this.carBrand = carBrand;
        this.carClass = carClass;
        this.weight = weight;
        this.empl = empl;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void start() {
        System.out.println("Go!!!");
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println(" startElectricity ");
    }

    private void startCommand() {
        System.out.println(" startCommand ");
    }

    protected void startFuelSystem() {
        System.out.println(" startFuelSystem ");
    }

    public void CarStr() {
        System.out.printf(" Car brand: %s \t Car class: %s \t Weight: %s \t  \n" +
                        " Name:  %s \t Post: %s \t Email: %s \t Phone: %s \t Age: %s \t  \n",
                getCarBrand(), getCarClass(), getWeight(), empl.getName(), empl.getPost(), empl.getEmail(),
                empl.getPhone(), empl.getAge());


    }
}
