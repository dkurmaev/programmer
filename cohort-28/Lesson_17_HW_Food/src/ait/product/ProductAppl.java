package ait.product;

import ait.product.model.Food;
import ait.product.model.MeatFood;
import ait.product.model.MilkFood;
import ait.product.model.Product;

public class ProductAppl {
    public static void main(String[] args) {
        Product[] products = new Product[5];

        products[0] = new Product(10.99, "Bread", 1234567890);
        products[1] = new Food(5.99, "Cucummber", 9876543210L, "2023-05-31");
        products[2] = new MeatFood(19.99, "Lamm", 1357924680L, "2023-06-15", "Beef");
        products[3] = new MilkFood(2.99, "Milk", 2468135790L, "2023-05-25", "Cow", 3.5);






        printNonFoodProducts(products);
        Product product = findProductByBarCode(products, 9876543210L);
        System.out.println("Product with barcode 9876543210 uneatable: " + product);
        System.out.println();
    }

    public static void printNonFoodProducts(Product[] products) {
        for (Product product1 : products) {
            if (!(product1 instanceof Food)) {
                System.out.println("Unfit for table: " + product1);
            }
        }
    }

    public static Product findProductByBarCode(Product[] products, long barCode) {
        for (Product product : products) {
            if (product.getBarCode() == barCode) {
                return product;
            }
        }
        return null;
    }
}