import entity.Tree;
import entity.TreeTypeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FlyweightTest {
    @ParameterizedTest
    @MethodSource("checkTreeTypesData")
    void checkTreeTypes(String name, String color, String texture) {
        Tree tree1 = new Tree(1, 1, TreeTypeFactory.getTreeType(name, color, texture));
        Tree tree2 = new Tree(0, 0, TreeTypeFactory.getTreeType(name, color, texture));
        Assertions.assertEquals(tree1.getType(), tree2.getType());
    }

    public static Stream<Arguments> checkTreeTypesData() {
        return Stream.of(
                Arguments.arguments("Birch", "Green", "Birch.png"),
                Arguments.arguments("", "Green", "Birch.png"),
                Arguments.arguments("Birch", "", "Birch.png"),
                Arguments.arguments("Birch", "Green", ""),
                Arguments.arguments("", "", "Birch.png"),
                Arguments.arguments("Birch", "", ""),
                Arguments.arguments("", "Green", ""),
                Arguments.arguments("", "", "")
        );
    }
}
