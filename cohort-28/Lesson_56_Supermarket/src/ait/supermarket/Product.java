package ait.supermarket;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private Long barCode;
    private String name;
    private String category;
    private String brand;
    private double price;
    private LocalDate expirationDate;


    public Product(Long barCode, String name, String category, String brand, double price, LocalDate expirationDate) {
        this.barCode = barCode;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public Product(String number, String category, String brand, String product, String date) {

    }

    public Long getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barCode=" + barCode +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(barCode, product.barCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }

    public boolean isExpired() {
        if (expirationDate == null) {
            return false;
        }
        return LocalDate.now().isAfter(expirationDate);
    }

    public int compareTo(Product otherProduct){
        return this.barCode.compareTo(otherProduct.barCode);
    }


}
