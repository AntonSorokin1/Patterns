package builders;

import entity.components.Roof;
import entity.components.RoofType;
import entity.components.Wall;

public class Director {
    public void constructSmallHouse(Builder<?> builder) {
        builder.setFoundation(true);
        builder.setWalls(4, Wall.WOOD);
        builder.setWindows(5);
        builder.setDoors(1);
        builder.setRoof(new Roof("Green", RoofType.ALUMINUM));
    }

    public void constructBigHouse(Builder<?> builder) {
        builder.setFoundation(true);
        builder.setWalls(40, Wall.BRICK);
        builder.setWindows(40);
        builder.setDoors(20);
        builder.setRoof(new Roof("Red", RoofType.SHINGLES));
        builder.setGarden(true);
        builder.setPool(true);
    }
}
