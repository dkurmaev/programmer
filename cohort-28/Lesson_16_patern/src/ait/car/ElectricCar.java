package ait.car;

import ait.car.model.Car;

public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String vendor, String brand, String plant, String model, String VIN, int year, double price, double engineVolume, String engineType, double speed, int mileage, boolean engineStatus, int batteryCapacity) {
        super(vendor, brand, plant, model, VIN, year, price, engineVolume, engineType, speed, mileage, engineStatus);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void display() {
        super.display();
        System.out.print("Battery Capacity: " + batteryCapacity + "-------->");

    }
}
