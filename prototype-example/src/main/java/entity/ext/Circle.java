package entity.ext;

import entity.Shape;

import java.util.Objects;

public class Circle extends Shape {
    private Double radius;

    public Circle(Circle circle) {
        super(circle);
        this.radius = circle.getRadius();
    }

    public Circle(Double x, Double y, Double radius) {
        super(x, y);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Objects.equals(radius, circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
