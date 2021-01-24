import builders.Builder;
import builders.Director;
import builders.impl.HouseBuilder;
import builders.impl.HousePlanBuilder;
import entity.House;
import entity.HousePlan;
import entity.components.Roof;
import entity.components.RoofType;
import entity.components.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class BuilderTest {
    @ParameterizedTest
    @MethodSource("builderProductCheckData")
    void builderHouseCheck(Boolean foundation, Integer numberOfWalls, Wall wallsType, Integer numberOfWindows,
                                    Integer numberOfDoors, Roof roof, Boolean garden, Boolean pool) {
        Builder<House> houseBuilder = new HouseBuilder() {{
            setFoundation(foundation);
            setWalls(numberOfWalls, wallsType);
            setDoors(numberOfDoors);
            setWindows(numberOfWindows);
            setRoof(roof);
            setGarden(garden);
            setPool(pool);
        }};

        List<Wall> walls = new ArrayList<>();
        for (int i = 0; i < numberOfWalls; i++) {
            walls.add(wallsType);
        }
        House expected = new House(foundation, walls, numberOfDoors, numberOfWindows, roof, garden, pool);

        Assertions.assertEquals(expected, houseBuilder.getResult());
    }

    @ParameterizedTest
    @MethodSource("builderProductCheckData")
    void builderHousePlanCheck(Boolean foundation, Integer numberOfWalls, Wall wallsType, Integer numberOfWindows,
                           Integer numberOfDoors, Roof roof, Boolean garden, Boolean pool) {
        Builder<HousePlan> houseBuilder = new HousePlanBuilder() {{
            setFoundation(foundation);
            setWalls(numberOfWalls, wallsType);
            setDoors(numberOfDoors);
            setWindows(numberOfWindows);
            setRoof(roof);
            setGarden(garden);
            setPool(pool);
        }};

        List<Wall> walls = new ArrayList<>();
        for (int i = 0; i < numberOfWalls; i++) {
            walls.add(wallsType);
        }
        HousePlan expected = new HousePlan(foundation, walls, numberOfDoors, numberOfWindows, roof, garden, pool);

        Assertions.assertEquals(expected.toString(), houseBuilder.getResult().toString());
    }

    @Test
    void directorBuildSmallHouseCheck() {
        Builder<House> builder = new HouseBuilder();
        Director director = new Director();
        director.constructSmallHouse(builder);

        Builder<House> checkedBuilder = new HouseBuilder() {{
            setFoundation(true);
            setWalls(4, Wall.WOOD);
            setDoors(1);
            setWindows(5);
            setRoof(new Roof("Green", RoofType.ALUMINUM));
        }};

        Assertions.assertEquals(checkedBuilder.getResult(), builder.getResult());
    }

    @Test
    void directorBuildBigHouseCheck() {
        Builder<House> builder = new HouseBuilder();
        Director director = new Director();
        director.constructBigHouse(builder);

        Builder<House> checkedBuilder = new HouseBuilder() {{
            setFoundation(true);
            setWalls(40, Wall.BRICK);
            setDoors(20);
            setWindows(40);
            setRoof(new Roof("Red", RoofType.SHINGLES));
            setGarden(true);
            setPool(true);
        }};

        Assertions.assertEquals(checkedBuilder.getResult(), builder.getResult());
    }

    public static Stream<Arguments> builderProductCheckData() {
        return Stream.of(
                Arguments.arguments(true, 4, Wall.WOOD, 5, 1, new Roof("Green", RoofType.ALUMINUM), null, null),
                Arguments.arguments(true, 40, Wall.BRICK, 40, 20, new Roof("Red", RoofType.SHINGLES), true, true)
        );
    }
}
