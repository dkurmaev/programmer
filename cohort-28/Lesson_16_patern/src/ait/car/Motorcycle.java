package ait.car;

import ait.car.model.Car;

public class Motorcycle extends Car {
    private String motorcycleType;

    public Motorcycle(String vendor, String brand, String plant, String model, String VIN, int year, double price,
                      double engineVolume, String engineType, double speed, int mileage, boolean engineStatus,
                      String motorcycleType) {
        super(vendor, brand, plant, model, VIN, year, price, engineVolume, engineType, speed, mileage, engineStatus);
        this.motorcycleType = motorcycleType;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }
    public void display(){
        super.display();
        System.out.print("Motorcycle Type: " + motorcycleType + "-------->");
    }
}

