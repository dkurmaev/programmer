package ait.supermarket.test;

import ait.supermarket.Product;
import ait.supermarket.dao.SupermarketImpl;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;
public class SupermarketImplTest {
    private SupermarketImpl supermarket;
    private Product product1;
    private Product product2;
    static final LocalDate now = LocalDate.now();
    @Before
    public void setUp() {
        supermarket = new SupermarketImpl();
        Product product1 = new Product(1564646L, "Tests", "Category1", "Brand1", 12.5, LocalDate.now());
        Product product2 = new Product(1564647L, "Tests", "Category2", "Brand5", 10.5, LocalDate.now());
        supermarket.addProduct(product1);
        supermarket.addProduct(product2);

    }

    @Test
    public void testAddProduct() {
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(new Product(1564647L, "Tests", "Category2", "Brand5", 10.5, LocalDate.now())));
        assertEquals(2, supermarket.skuQuantity());
        assertTrue(supermarket.addProduct(new Product(1564648L, "Tests", "Category3", "Brand2", 15.5, LocalDate.now())));
        assertEquals(3, supermarket.skuQuantity());
    }



    @Test
    public void testRemoveProduct() {
        assertFalse(supermarket.removeProduct(1564647L));
        assertEquals(1, supermarket.skuQuantity());
    }

    @Test
    public void testFindByBarCode() {
        Product product1 = supermarket.findByBarCode(1564646L);
        assertEquals(1564646L, product1.getBarCode().longValue());
        assertEquals("Tests", product1.getName());
        assertEquals("Category1", product1.getCategory());
        assertEquals("Brand1", product1.getBrand());
        assertNull(supermarket.findByBarCode(1234L));

    }

//    @Test
//    public void testFindByCategory() {
//        Iterable<Product> products = supermarket.findByCategory("Category1");
//        List<Product> actual = new ArrayList<>();
//        for (Product product : products) {
//            actual.add(product);
//        }
//        Collections.sort(actual);
//        List<Product> expected = new ArrayList<>();
//        new Product(1564646L, "Tests", "Category1", "Brand1", 12.5, LocalDate.now()),
//        new Product(1564647L, "Tests", "Category1", "Brand5", 10.5, LocalDate.now())
//       );
//        assertIterableEquaals(expected, actual);
//
//    }

    @Test
    public void testFindByBrand() {
        Iterable<Product> result = supermarket.findByBrand("Brand1");
        List<Product> productList = new ArrayList<>();
        for (Product product : result) {
            productList.add(product);
        }
        assertTrue(productList.contains(new Product(1564646L, "Tests", "Category1", "Brand1", 12.5, LocalDate.now())));
        assertFalse(productList.contains(new Product(1564647L, "Tests", "Category2", "Brand5", 10.5, LocalDate.now())));
    }

    @Test
    public void testFindProductsWithExpDate() {
        Iterable<Product> products = supermarket.findProductsWithExpDate("Tests");
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            productList.add(product);
        }
    }



    @Test
    public void testSkuQuantity() {
        Product product1 = new Product(1564646L, "Tests", "Category1", "Brand1", 12.5, LocalDate.now());
        Product product2 = new Product(1564647L, "Tests", "Category2", "Brand5", 10.5, LocalDate.now());
        supermarket.removeProduct(1564646L);
        supermarket.addProduct(product1);
        supermarket.addProduct(product2);
        assertEquals(2, supermarket.skuQuantity());
    }
}
