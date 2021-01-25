package entity;

public class UnitSnapshot {
    private final Unit unit;
    private final Integer x;
    private final Integer y;

    public UnitSnapshot(Unit unit, Integer x, Integer y) {
        this.unit = unit;
        this.x = x;
        this.y = y;
    }

    public void restore() {
        unit.setX(x);
        unit.setY(y);
    }
}
