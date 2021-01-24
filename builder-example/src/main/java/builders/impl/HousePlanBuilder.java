package builders.impl;

import builders.Builder;
import entity.HousePlan;
import entity.components.Roof;
import entity.components.Wall;

import java.util.ArrayList;
import java.util.List;

public class HousePlanBuilder implements Builder<HousePlan> {
    private Boolean foundation;
    private List<Wall> walls;
    private Integer doors;
    private Integer windows;
    private Roof roof;
    private Boolean garden;
    private Boolean pool;

    @Override
    public void setFoundation(Boolean foundation) {
        this.foundation = foundation;
    }

    @Override
    public void setWalls(Integer number, Wall type) {
        walls = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            walls.add(type);
        }
    }

    @Override
    public void setDoors(Integer numberOfDoors) {
        this.doors = numberOfDoors;
    }

    @Override
    public void setWindows(Integer numberOfWindows) {
        this.windows = numberOfWindows;
    }

    @Override
    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public void setGarden(Boolean garden) {
        this.garden = garden;
    }

    @Override
    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    @Override
    public HousePlan getResult() {
        return new HousePlan(foundation, walls, doors, windows, roof, garden, pool);
    }
}
