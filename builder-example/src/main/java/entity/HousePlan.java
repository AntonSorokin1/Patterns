package entity;

import entity.components.Roof;
import entity.components.Wall;

import java.util.List;

public class HousePlan {
    private final Boolean foundation;
    private final List<Wall> walls;
    private final Integer doors;
    private final Integer windows;
    private final Roof roof;
    private final Boolean garden;
    private final Boolean pool;

    public HousePlan(Boolean foundation, List<Wall> walls, Integer doors, Integer windows, Roof roof, Boolean garden, Boolean pool) {
        this.foundation = foundation;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
        this.roof = roof;
        this.garden = garden;
        this.pool = pool;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Foundation: ").append(foundation).append('\n');
        sb.append("Walls:\n")
                .append("\tnumber: ").append(walls.size()).append('\n')
                .append("\ttype: ").append(walls.get(0).toString()).append('\n');
        sb.append("Number of doors").append(doors).append('\n');
        sb.append("Number of windows: ").append(windows).append('\n');
        sb.append("Roof:\n")
                .append("\tcolor: ").append(roof.getColor()).append('\n')
                .append("\ttype: ").append(roof.getType().toString()).append('\n');
        if (garden != null) {
            sb.append("Garden: ").append(garden).append('\n');
        }
        if (pool != null) {
            sb.append("Pool: ").append(pool).append('\n');
        }

        return sb.toString();
    }
}
