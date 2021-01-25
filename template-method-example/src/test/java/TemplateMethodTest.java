import entity.Animal;
import entity.objects.Bear;
import entity.objects.Duck;
import entity.objects.Squirrel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TemplateMethodTest {
    @ParameterizedTest
    @MethodSource("checkMoveMethodData")
    void checkMoveMethod(Animal animal, String expected) {
        Assertions.assertEquals(expected, animal.move());
    }

    @ParameterizedTest
    @MethodSource("checkEatMethodData")
    void checkEatMethod(Animal animal, String expected) {
        Assertions.assertEquals(expected, animal.eat());
    }

    @ParameterizedTest
    @MethodSource("checkSleepMethodData")
    void checkSleepMethod(Animal animal, String expected) {
        Assertions.assertEquals(expected, animal.sleep());
    }

    public static Stream<Arguments> checkMoveMethodData() {
        return Stream.of(
                Arguments.arguments(new Bear(), "Двигается по земле"),
                Arguments.arguments(new Duck(), "Двигается везде"),
                Arguments.arguments(new Squirrel(), "Двигается по земле")
        );
    }

    public static Stream<Arguments> checkEatMethodData() {
        return Stream.of(
                Arguments.arguments(new Bear(), "Ест рыбу"),
                Arguments.arguments(new Duck(), "Ест рыбу"),
                Arguments.arguments(new Squirrel(), "Ест орехи")
        );
    }

    public static Stream<Arguments> checkSleepMethodData() {
        return Stream.of(
                Arguments.arguments(new Bear(), "Спит всю зиму"),
                Arguments.arguments(new Duck(), "В спячку не впадает"),
                Arguments.arguments(new Squirrel(), "Спит всю зиму")
        );
    }
}
