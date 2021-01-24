package entity.products;

import entity.Product;

public class Pencile implements Product {
    private final Double price;

    public Pencile(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
