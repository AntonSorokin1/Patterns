package entity.impl;

import entity.Prototype;

import java.util.Objects;

public class GameObject implements Prototype<GameObject> {
    private Integer id;
    private Coordinates coordinates;

    public GameObject(Integer id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public GameObject getClone() {
        return new GameObject(id, coordinates.getClone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
