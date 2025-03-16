package org.example;

public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce() {
        return downforce;
    }

    @Override
    public double calculatePerfomance(){ //numbers are made up
        return getHorsepower() * 0.9 + downforce * 2.0;
    }
}
