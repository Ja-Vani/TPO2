package ru.javani.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SystemFunctionTest {

    @Test
    void shouldNotAcceptZeroArgument() {
        final SystemFunction system = new SystemFunction();
        assertThrows(ArithmeticException.class, () -> system.calculate(0, 0.000_000_01));
    }

    @Test
    void shouldNotAcceptOneArgument() {
        final SystemFunction system = new SystemFunction();
        assertEquals(0, system.calculate(1, 0.000_000_01));
    }

    @Test
    void shouldCalculateForPositiveValue() {
        final SystemFunction system = new SystemFunction();
        final double expected = 2.506_801;
        assertEquals(String.format("%.5f", expected), String.format("%.5f", system.calculate(5, 0.000_001)));
    }

    @Test
    void shouldCalculateForNegativeValue() {
        final SystemFunction system = new SystemFunction();
        final double expected = 37.942_101_50;
        assertEquals(String.format("%.7f", expected), String.format("%.7f", system.calculate(-5, 0.000_000_01)));
    }

}
