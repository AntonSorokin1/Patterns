import entity.Shape;
import entity.Visitor;
import entity.shapes.Circle;
import entity.shapes.Dot;
import entity.shapes.Rectangle;
import entity.visitors.JSONExportVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class VisitorTest {
    public static Visitor visitor;

    @BeforeEach
    public void before() {
        visitor = new JSONExportVisitor();
    }

    @ParameterizedTest
    @MethodSource("checkVisitorOnShapeData")
    void checkVisitorOnShape(Shape shape, String expected) {
        Assertions.assertEquals(expected, shape.accept(visitor));
    }

    public static Stream<Arguments> checkVisitorOnShapeData() {
        return Stream.of(
                Arguments.arguments(new Dot(), "Export dot"),
                Arguments.arguments(new Circle(), "Export circle"),
                Arguments.arguments(new Rectangle(), "Export rectangle")
        );
    }
}
