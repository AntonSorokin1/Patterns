package builders;

import entity.components.Roof;
import entity.components.Wall;

public interface Builder<T> {
    void setFoundation(Boolean foundation);

    void setWalls(Integer number, Wall type);

    void setDoors(Integer numberOfDoors);

    void setWindows(Integer numberOfWindows);

    void setRoof(Roof roof);

    void setGarden(Boolean garden);

    void setPool(Boolean pool);

    T getResult();
}
