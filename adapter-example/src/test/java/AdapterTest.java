import entity.RoundHole;
import entity.RoundPeg;
import entity.SquarePeg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.SquarePegAdapter;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class AdapterTest {
    @ParameterizedTest
    @MethodSource("positiveCheckingHoleAndPegData")
    void positiveCheckingHoleAndPeg(Double holeRadius, Double pegRadius) {
        RoundHole hole = new RoundHole(holeRadius);
        RoundPeg peg = new RoundPeg(pegRadius);
        Assertions.assertTrue(hole.fits(peg));
    }

    @ParameterizedTest
    @MethodSource("negativeCheckingHoleAndPegData")
    void negativeCheckingHoleAndPeg(Double holeRadius, Double pegRadius) {
        RoundHole hole = new RoundHole(holeRadius);
        RoundPeg peg = new RoundPeg(pegRadius);
        Assertions.assertFalse(hole.fits(peg));
    }

    @ParameterizedTest
    @MethodSource("positiveCheckingHoleAndPegData")
    void adapterPositiveCheck(Double holeRadius, Double pegWidth) {
        RoundHole hole = new RoundHole(holeRadius);
        SquarePeg peg = new SquarePeg(pegWidth);
        SquarePegAdapter adapter = new SquarePegAdapter(peg);
        Assertions.assertTrue(hole.fits(adapter));
    }

    @ParameterizedTest
    @MethodSource("negativeCheckingHoleAndPegData")
    void adapterNegativeCheck(Double holeRadius, Double pegWidth) {
        RoundHole hole = new RoundHole(holeRadius);
        SquarePeg peg = new SquarePeg(pegWidth);
        SquarePegAdapter adapter = new SquarePegAdapter(peg);
        Assertions.assertFalse(hole.fits(adapter));
    }

    public static Stream<Arguments> positiveCheckingHoleAndPegData() {
        return Stream.of(
                arguments(1d, 0d),
                arguments(2d, 1d),
                arguments(0d, 0d)
        );
    }

    public static Stream<Arguments> negativeCheckingHoleAndPegData() {
        return Stream.of(
                arguments(0d, 1d),
                arguments(1d, 2d),
                arguments(-1d, 2d)
        );
    }
}
