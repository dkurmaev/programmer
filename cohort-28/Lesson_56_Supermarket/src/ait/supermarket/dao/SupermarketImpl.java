package ait.supermarket.dao;

import ait.supermarket.Product;

import java.util.*;

public class SupermarketImpl implements Supermarket {
    private final Map<Long, Product> productsMap;

    public SupermarketImpl() {
        productsMap = new HashMap<>();
    }

    // O(1)
    @Override
    public Iterator<Product> iterator() {
        return productsMap.values().iterator();
    }

    // O(n)
    @Override
    public boolean addProduct(Product product) {
        if (product == null || product.getBarCode() == null) {
            return false;
        }
        if (productsMap.containsKey(product.getBarCode())) {
            return false;
        }
        productsMap.put(product.getBarCode(), product);
        return true;
    }

    // O(1)
    @Override
    public boolean removeProduct(Long barCode) {
        return productsMap.remove(barCode).isExpired();
    }


    // O(1)
    @Override
    public Product findByBarCode(Long barCode) {
        return productsMap.get(barCode);
    }

    //O(n)
    @Override
    public Iterable<Product> findByCategory(String category) {
        Collection<Product> matchingProducts = new ArrayList<>();
        for (Product product : productsMap.values()) {
            if (product.getCategory().equals(category)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    //O(n)
    @Override
    public Iterable<Product> findByBrand(String brand) {
        Collection<Product> matchingProducts = new ArrayList<>();
        for (Product product : productsMap.values()) {
            if (product.getBrand().equals(brand)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    //O(n)
    @Override
    public Iterable<Product> findProductsWithExpDate(String name) {
        Collection<Product> matchingProducts = new ArrayList<>();
        for (Product product : productsMap.values()) {
            if (product.getName().equals(name) && product.isExpired()) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    //O(1)
    @Override
    public int skuQuantity() {
        return productsMap.size();
    }
}
