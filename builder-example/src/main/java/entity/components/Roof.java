package entity.components;

import java.util.Objects;

public class Roof {
    private String color;
    private RoofType type;

    public Roof(String color, RoofType type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RoofType getType() {
        return type;
    }

    public void setType(RoofType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roof roof = (Roof) o;
        return Objects.equals(color, roof.color) && type == roof.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
