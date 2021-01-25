import api.Strategy;
import api.strategies.AddStrategy;
import api.strategies.MultiplyStrategy;
import api.strategies.SubtractStrategy;
import entity.Calculator;
import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StrategyTest {
    private static Calculator calculator;

    @BeforeEach
    public void before() {
        calculator = new Calculator(new AddStrategy());
    }

    @ParameterizedTest
    @MethodSource("checkSimpleStrategyData")
    void checkSimpleStrategy(Strategy strategy, Integer a, Integer b, Integer result) {
        calculator.setStrategy(strategy);
        Assertions.assertEquals(result, calculator.count(a, b));
    }

    @ParameterizedTest
    @MethodSource("checkComplicateStrategyData")
    void checkComplicateStrategy(List<Pair<Strategy, Integer>> expressions, Integer startValue, Integer expectedResult) {
        Integer result = startValue;
        for (Pair<Strategy, Integer> expression : expressions) {
            calculator.setStrategy(expression.getKey());
            result = calculator.count(result, expression.getValue());
        }
        Assertions.assertEquals(expectedResult, result);
    }

    public static Stream<Arguments> checkSimpleStrategyData() {
        return Stream.of(
                Arguments.arguments(new AddStrategy(), 1, 1, 2),
                Arguments.arguments(new SubtractStrategy(), 1, 1, 0),
                Arguments.arguments(new MultiplyStrategy(), 1, 1, 1)
        );
    }

    public static Stream<Arguments> checkComplicateStrategyData() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new Pair<>(new AddStrategy(), 1),
                                new Pair<>(new AddStrategy(), 1),
                                new Pair<>(new AddStrategy(), 1)),
                        0, 3),
                Arguments.arguments(
                        Arrays.asList(
                                new Pair<>(new SubtractStrategy(), 1),
                                new Pair<>(new SubtractStrategy(), 1),
                                new Pair<>(new SubtractStrategy(), 1)),
                        3, 0),
                Arguments.arguments(
                        Arrays.asList(
                                new Pair<>(new MultiplyStrategy(), 2),
                                new Pair<>(new MultiplyStrategy(), 2),
                                new Pair<>(new MultiplyStrategy(), 2)),
                        1, 8),
                Arguments.arguments(
                        Arrays.asList(
                                new Pair<>(new AddStrategy(), 2),
                                new Pair<>(new SubtractStrategy(), 2),
                                new Pair<>(new MultiplyStrategy(), 10)),
                        0, 0)

        );
    }
}
