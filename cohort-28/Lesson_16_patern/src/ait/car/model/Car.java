package ait.car.model;

public class Car {
    private String vendor;
    private String brand;
    private String plant;
    private String model;
    private String VIN;
    private int year;
    private double price;
    private double engineVolume;
    private String engineType;
    private double speed;
    private long mileage;
    private boolean engineStatus;

    public Car() {
    }

    public Car(String vendor, String brand, String plant, String model, String VIN, int year, double price, double engineVolume, String engineType, double speed, long mileage, boolean engineStatus) {
        this.vendor = vendor;
        this.brand = brand;
        this.plant = plant;
        this.model = model;
        this.VIN = VIN;
        this.year = year;
        this.price = price;
        this.engineVolume = engineVolume;
        this.engineType = engineType;
        this.speed = speed;
        this.mileage = mileage;
        this.engineStatus = engineStatus;


    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public boolean isEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(boolean engineStatus) {
        this.engineStatus = engineStatus;
    }

    public void display() {
        System.out.println("***************************************************************************************************" +
                "**********************************************************************************************************");
        System.out.println("Car Details:");
        System.out.println("Vendor: " + vendor + ", Brand: " + brand + ", Plant: " + plant + ", Model: " + model + ", VIN: " + VIN + ", Year: " +
                year + ", Price: " + price + ", Engine Volume: " + engineVolume + ", Engine Type: "
                + engineType + ", Speed: " + speed + ", Mileage: " + mileage + ",  Engine Status: " + (engineStatus ? "Running" : "Stopped"));
    }

    public void startEngine() {
        if (!engineStatus) {
            System.out.println("Engine started.");
            engineStatus = true;
        } else {
            System.out.println("Engine is already running.");
        }
    }

    public void move() {
        if (engineStatus) {
            System.out.println("Car is moving.");
        } else {
            System.out.println("Cannot move. Engine is not running.");
        }
    }

    public void stop() {
        if (engineStatus) {
            System.out.println("Car stopped.");
            engineStatus = false;
        } else {
            System.out.println("Engine is already stopped.");
        }
    }

    public void updateMileage(long newMileage) {
        mileage = newMileage;
        System.out.println("Mileage updated: " + mileage);


    }

    public void changeMileage(int distance) {
        if (distance >= 0) {
            mileage += distance;
            System.out.println("Mileage changed. New mileage: " + mileage);
        } else {
            System.out.println("Invalid distance. Mileage not changed.");
        }
    }
}

