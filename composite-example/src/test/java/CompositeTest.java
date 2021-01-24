import entity.Product;
import entity.products.Box;
import entity.products.Headphone;
import entity.products.Pencile;
import entity.products.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class CompositeTest {
    @ParameterizedTest
    @MethodSource("checkPriceData")
    void checkPrice(Product product, Double expected) {
        Assertions.assertEquals(expected, product.getPrice());
    }

    public static Stream<Arguments> checkPriceData() {
        return Stream.of(
                Arguments.arguments(new Pencile(15.5), 15.5),
                Arguments.arguments(new Phone(100d), 100d),
                Arguments.arguments(new Headphone(50.33), 50.33),
                Arguments.arguments(new Box(Arrays.asList(
                    new Phone(150d), new Headphone(50d)
                )), 200d),
                Arguments.arguments(new Box(Collections.singletonList(
                        new Pencile(11.99)
                )), 11.99),
                Arguments.arguments(new Box(Arrays.asList(
                        new Box(Arrays.asList(new Phone(150d), new Headphone(50d))),
                        new Box(Arrays.asList(new Pencile(15.5), new Pencile(15.5)))
                )), 231d),
                Arguments.arguments(new Box(Arrays.asList(
                        new Box(Arrays.asList(new Phone(150d), new Headphone(50d))),
                        new Box(Arrays.asList(
                                new Box(Collections.singletonList(new Pencile(9.99))),
                                new Phone(200.5)
                        ))
                )), 410.49),
                Arguments.arguments(new Box(), 0d)
        );
    }
}
