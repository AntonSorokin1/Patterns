import entity.Prototype;
import entity.Shape;
import entity.ext.Circle;
import entity.ext.Square;
import entity.impl.Coordinates;
import entity.impl.GameObject;
import entity.impl.Sheep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PrototypeTest {
    @ParameterizedTest
    @MethodSource("interfacePrototypeCloneMethodData")
    void interfacePrototypeCloneMethod(Prototype<?> prototype) {
        Assertions.assertEquals(prototype, prototype.getClone());
    }

    @Test
    void interfacePrototypeChangeOriginal() {
        Sheep dolly = new Sheep(5, "Dolly", "white");
        Sheep dolly2 = dolly.getClone();
        dolly.setColor("black");
        Assertions.assertNotEquals(dolly, dolly2);
    }

    @ParameterizedTest
    @MethodSource("abstractClassCloneMethodData")
    void abstractClassCloneMethod(Shape shape) {
        Assertions.assertEquals(shape, shape.clone());
    }

    public static Stream<Prototype<?>> interfacePrototypeCloneMethodData() {
        return Stream.of(
                new Sheep(5, "Dolly", "white"),
                new Coordinates(1, 2),
                new GameObject(1, new Coordinates(0, 0))
        );
    }

    public static Stream<Shape> abstractClassCloneMethodData() {
        return Stream.of(
                new Circle(0d, 0d, 5d),
                new Square(0d, 0d, 5d, 5d)
        );
    }
}
