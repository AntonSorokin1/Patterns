package entity.ext;

import entity.Shape;

import java.util.Objects;

public class Square extends Shape {
    private Double width;
    private Double height;

    public Square(Square square) {
        super(square);
        this.width = square.getWidth();
        this.height = square.getHeight();
    }

    public Square(Double x, Double y, Double width, Double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Square(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Objects.equals(width, square.width) && Objects.equals(height, square.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }
}
