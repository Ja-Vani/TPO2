package ru.javani.function;

import org.junit.jupiter.api.Test;
import ru.javani.log.LogFunc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogFunctionTest {

    @Test
    void shouldNotCalculateForZero() {
        final LogFunc log = new LogFunc(5);
        assertThrows(ArithmeticException.class, () -> log.calculate(0, 0.000_001));
    }

    @Test
    void shouldCalculateForOne() {
        final LogFunc log = new LogFunc(5);
        assertEquals(
                0, log.calculate(1, 0.000_001));
    }

    @Test
    void shouldCalculateForPositive() {
        final LogFunc log = new LogFunc(5);
        final double expected = 2.466_88;
        assertEquals(String.format("%.5f", expected), String.format("%.5f", log.calculate(53, 0.000_001)));
    }
}
