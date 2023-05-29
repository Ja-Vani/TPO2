package ru.javani.function;

import org.junit.jupiter.api.Test;
import ru.javani.trigonometry.SinFunc;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinFunctionTest {
    @Test
    void shouldCalculateForZero() {
        final SinFunc sin = new SinFunc();
        assertEquals(0, sin.calculate(0, 0.000_001));
    }

    @Test
    void shouldCalculateForPiDividedByTwo() {
        final SinFunc sin = new SinFunc();
        assertEquals(
                String.format("%.5f", 1.0), String.format("%.5f", sin.calculate(Math.PI / 2, 0.000_001)));
    }

    @Test
    void shouldCalculateForOne() {
        final SinFunc sin = new SinFunc();
        final double expected = 0.841_47;
        assertEquals(String.format("%.5f", expected), String.format("%.5f",sin.calculate(1, 0.000_001)));
    }

    @Test
    void shouldCalculateForPeriodicNeg() {
        final SinFunc sin = new SinFunc();
        final double expected = 0.097_17;
        assertEquals(String.format("%.5f", expected), String.format("%.5f", sin.calculate(-113, 0.000_001)));
    }
    @Test
    void shouldCalculateForPeriodicPos() {
        final SinFunc sin = new SinFunc();
        final double expected = -0.097_12;
        assertEquals(String.format("%.5f", expected), String.format("%.5f", sin.calculate(113, 0.000_001)));
    }
}
