import api.NumberIterator;
import api.impl.NumberArrayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IteratorTest {
    @ParameterizedTest
    @MethodSource("checkOddNumbersData")
    void checkOddNumbers(Integer[] numbers, String expected) {
        NumberArrayImpl array = new NumberArrayImpl(numbers);
        NumberIterator iterator = array.createOddNumberIterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasMore()) {
            result.append(iterator.getNext()).append(" ");
        }
        result.setLength(Math.max(result.length() - 1, 0));
        Assertions.assertEquals(expected, result.toString());
    }

    @ParameterizedTest
    @MethodSource("checkEvenNumbersData")
    void checkEvenNumbers(Integer[] numbers, String expected) {
        NumberArrayImpl array = new NumberArrayImpl(numbers);
        NumberIterator iterator = array.createEvenNumberIterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasMore()) {
            result.append(iterator.getNext()).append(" ");
        }
        result.setLength(Math.max(result.length() - 1, 0));
        Assertions.assertEquals(expected, result.toString());
    }

    public static Stream<Arguments> checkOddNumbersData() {
        return Stream.of(
                Arguments.arguments(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, "1 3 5 7 9"),
                Arguments.arguments(new Integer[]{2, 4, 6, 8}, ""),
                Arguments.arguments(new Integer[]{1}, "1"),
                Arguments.arguments(new Integer[]{}, "")
        );
    }

    public static Stream<Arguments> checkEvenNumbersData() {
        return Stream.of(
                Arguments.arguments(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, "2 4 6 8"),
                Arguments.arguments(new Integer[]{1, 3, 5, 7, 9}, ""),
                Arguments.arguments(new Integer[]{0}, "0"),
                Arguments.arguments(new Integer[]{2, 2, 2, 2}, "2 2 2 2"),
                Arguments.arguments(new Integer[]{}, "")
        );
    }
}
