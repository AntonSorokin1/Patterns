package entity;

public class RoundHole {
    private Double radius;

    public RoundHole(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}
