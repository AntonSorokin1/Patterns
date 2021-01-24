package entity;

import entity.components.Roof;
import entity.components.Wall;

import java.util.List;
import java.util.Objects;

public class House {
    private Boolean foundation;
    private List<Wall> walls;
    private Integer doors;
    private Integer windows;
    private Roof roof;
    private Boolean garden;
    private Boolean pool;

    public House() {
    }

    public House(Boolean foundation, List<Wall> walls, int doors, int windows, Roof roof, Boolean garden, Boolean pool) {
        this.foundation = foundation;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
        this.roof = roof;
        this.garden = garden;
        this.pool = pool;
    }

    public Boolean getFoundation() {
        return foundation;
    }

    public void setFoundation(Boolean foundation) {
        this.foundation = foundation;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getWindows() {
        return windows;
    }

    public void setWindows(Integer windows) {
        this.windows = windows;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public Boolean getGarden() {
        return garden;
    }

    public void setGarden(Boolean garden) {
        this.garden = garden;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(foundation, house.foundation) &&
                Objects.equals(walls, house.walls) &&
                Objects.equals(doors, house.doors) &&
                Objects.equals(windows, house.windows) &&
                Objects.equals(roof, house.roof) &&
                Objects.equals(garden, house.garden) &&
                Objects.equals(pool, house.pool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundation, walls, doors, windows, roof, garden, pool);
    }
}
