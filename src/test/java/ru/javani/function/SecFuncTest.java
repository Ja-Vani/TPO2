package ru.javani.function;

import org.junit.jupiter.api.Test;
import ru.javani.trigonometry.SecFunc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SecFuncTest {

    @Test
    void shouldNotCalculateForPiDividedByTwo() {
        final SecFunc sec = new SecFunc();
        assertThrows(ArithmeticException.class, () -> sec.calculate(Math.PI / 2, 0.000_001));
    }

    @Test
    void shouldCalculateForOne() {
        final SecFunc sec = new SecFunc();
        final double expected = 1.8508;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", sec.calculate(1, 0.000_001)));
    }

    @Test
    void shouldCalculateForPeriodic() {
        final SecFunc sec = new SecFunc();
        final double expected = 2.1560;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", sec.calculate(134, 0.000_001)));
    }
}
