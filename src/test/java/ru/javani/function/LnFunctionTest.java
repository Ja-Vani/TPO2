package ru.javani.function;

import org.junit.jupiter.api.Test;
import ru.javani.log.LnFunc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LnFunctionTest {
    @Test
    void shouldNotCalculateForZero() {
        final LnFunc ln = new LnFunc();
        assertThrows(ArithmeticException.class, () -> ln.calculate(0, 0.000_001));
    }

    @Test
    void shouldCalculateForOne() {
        final LnFunc ln = new LnFunc();
        assertEquals(0, ln.calculate(1, 0.000_001));
    }

    @Test
    void shouldCalculateForPositive() {
        final LnFunc ln = new LnFunc();
        final double expected = 1.386_29;
        assertEquals( String.format("%.5f",expected),  String.format("%.5f",ln.calculate(4, 0.000_001)));
    }
}
