package ait.car;

import ait.car.model.Car;

public class Engine extends Car {
    private String engineModel;

    public Engine(String vendor, String brand, String plant, String model, String VIN, int year, double price,
                  double engineVolume, String engineType, double speed, int mileage, boolean engineStatus,
                  String engineModel) {
        super(vendor, brand, plant, model, VIN, year, price, engineVolume, engineType, speed, mileage, engineStatus);
        this.engineModel = engineModel;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }
    public void display(){
        super.display();
        System.out.print("Engine Model: " + engineModel + "-------->");
    }



}
