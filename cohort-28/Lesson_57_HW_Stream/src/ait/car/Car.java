package ait.car;

public class Car {
    private String model;
    private int price;
    private String color;

    public Car(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public Car(String model, int price, String color) {
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
