package ait.computer.model;

public class Smartphone extends Laptop {

    private long imei;

    private double display;

    public Smartphone(String cpu, int ram, int ssd, String brand, double hours, double weight, long imei, double display) {
        super(cpu, ram, ssd, brand, hours, weight);
        this.imei = imei;
        this.display = display;
    }

    public long getImei() {
        return imei;
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }
    public void display(){
        super.display();
        System.out.println(", IMEI: " + imei + ", Display: " + display);
    }
}
