package org.example;

public class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    @Override
    public double calculatePerfomance(){
        return getHorsepower() * 0.8 + suspensionTravel * 1.5;
    }
}
