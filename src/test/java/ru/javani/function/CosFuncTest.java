package ru.javani.function;

import org.junit.jupiter.api.Test;
import ru.javani.trigonometry.CosFunc;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CosFuncTest {
    @Test
    void shouldCalculateForZero() {
        final CosFunc cos = new CosFunc();
        assertEquals(1, cos.calculate(0, 0.000_001));
    }

    @Test
    void shouldCalculateForPiDividedByTwo() {
        final CosFunc cos = new CosFunc();
        assertEquals(
                String.format("%.2f", 0.0), String.format("%.2f", cos.calculate(Math.PI / 2.0, 0.000_001)));
    }

    @Test
    void shouldCalculateForOne() {
        final CosFunc cos = new CosFunc();
        final double expected = 0.5403;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", cos.calculate(1, 0.000_001)));
    }

    @Test
    void shouldCalculateForPeriodic() {
        final CosFunc cos = new CosFunc();
        final double expected = 0.8797;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", cos.calculate(-543, 0.000_001)));
    }
}
