package ait.supermarket.model;

import java.util.Objects;

public class Product {

    private final long barCode;
    private String brand;

    private String productType;
    private double price;

    public Product(long barCode, String brand, double price, String productType) {
        this.barCode = barCode;
        this.brand = brand;
        this.price = price;
        this.productType = productType;
    }

    public Product(long barCode) {
        this.barCode = barCode;
    }

    public long getBarCode() {
        return barCode;
    }

    public String getName() {
        return brand;
    }

    public void setName(String name) {
        this.brand = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductType() {
        return productType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product " + "barCode= " + barCode + ", brand= " + brand +  ", productType= " + productType +  ", price= " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return barCode == product.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }
}
