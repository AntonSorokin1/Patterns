package entity;

import java.util.Objects;

public abstract class Shape {
    private Double x;
    private Double y;

    protected Shape(Shape shape) {
        if (shape != null) {
            this.x = shape.getX();
            this.y = shape.getY();
        }
    }

    protected Shape(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(x, shape.x) && Objects.equals(y, shape.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
