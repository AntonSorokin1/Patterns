package entity.products;

import entity.Product;

public class Phone implements Product {
    private final Double price;

    public Phone(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
