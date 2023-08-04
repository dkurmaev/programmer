package ait.product.model;

public class Product {
    private double price;
    private String name;
    private long barCode;

    public Product(double price, String name, long barCode) {
        this.price = price;
        this.name = name;
        this.barCode = barCode;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public long getBarCode() {
        return barCode;
    }

    @Override
    public String toString() {
        return "Price = " + price + ", Name = " + name + ", Barcode = " + barCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return barCode == other.barCode;
    }
}