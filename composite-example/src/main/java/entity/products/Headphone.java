package entity.products;

import entity.Product;

public class Headphone implements Product {
    private final Double price;

    public Headphone(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
