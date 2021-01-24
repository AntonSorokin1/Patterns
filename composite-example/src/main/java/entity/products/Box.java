package entity.products;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Box implements Product {
    private final List<Product> products;

    public Box() {
        this.products = new ArrayList<>();
    }

    public Box(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Double getPrice() {
        Double sum = 0d;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}
