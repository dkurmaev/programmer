package ait.supermarket.dao;

import ait.supermarket.Product;

import java.util.Iterator;

public interface Supermarket {
    Iterator<Product> iterator();

    boolean addProduct(Product product);
    boolean removeProduct(Long barCode);
    Product findByBarCode(Long barCode);
    Iterable<Product> findByCategory(String category);
    Iterable<Product> findByBrand(String brand);
    Iterable<Product> findProductsWithExpDate(String name);
    int skuQuantity();

}
