package ait.supermarket.model;

import java.util.Objects;

public class Food extends Product {

    private String extendsDay;

    private String vendor;

    public Food(long barCode, String brand, double price, String productType, String extendsDay, String vendor) {
        super(barCode, brand, price, productType);
        this.extendsDay = extendsDay;
        this.vendor = vendor;
    }

    public Food(long barCode, String brand, double price, String productType) {
        super(barCode, brand, price, productType);
    }

    public String getExtendsDay() {
        return extendsDay;
    }

    public void setExtendsDay(String extendsDay) {
        this.extendsDay = extendsDay;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return ", ExtendsDay= " + extendsDay +  ", Vendor= " + vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return Objects.equals(extendsDay, food.extendsDay) && Objects.equals(vendor, food.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extendsDay, vendor);
    }
}
