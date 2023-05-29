package ru.javani.function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import ru.javani.trigonometry.CosFunc;
import ru.javani.trigonometry.SinFunc;
import ru.javani.trigonometry.TgFunc;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TgFuncTest {
    @Mock
    private SinFunc mockSin;
    @Mock
    private CosFunc mockCos;
    @Spy
    private SinFunc spySin;

    @Test
    void shouldCallSinAndCosFunctions() {
        final CosFunc cos = new CosFunc(spySin);
        final CosFunc spyCos = spy(cos);

        final TgFunc tan = new TgFunc(spySin, spyCos);
        tan.calculate(0, 0.000_001);

        verify(spySin, atLeastOnce()).calculate(any(Double.class), any(Double.class));
        verify(spyCos, atLeastOnce()).calculate(any(Double.class), any(Double.class));
    }

    @Test
    void shouldCalculateWithMockSinAndMockCos() {
        final double arg = 5;

        when(mockSin.calculate(eq(arg), any(Double.class)))
                .thenReturn(-0.958_924_27);
        when(mockCos.calculate(eq(arg), any(Double.class)))
                .thenReturn(0.283_662_18);

        final TgFunc tan = new TgFunc(mockSin, mockCos);
        final double expectedResult = -3.3805;
        assertEquals(String.format("%.4f", expectedResult), String.format("%.4f", tan.calculate(arg, 0.000_001)));
    }

    @Test
    void shouldCalculateForZero() {
        final TgFunc tan = new TgFunc();
        assertEquals(
                String.format("%.4f", 0.0),
                String.format("%.4f", tan.calculate(0, 0.000_001)));
    }

    @Test
    void shouldNotCalculateForPiDividedByTwo() {
        final TgFunc tan = new TgFunc();
        assertThrows(ArithmeticException.class, () -> tan.calculate(Math.PI / 2, 0.000_001));
    }

    @Test
    void shouldCalculateForOne() {
        final TgFunc tan = new TgFunc();
        final double expected = 1.5574;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", tan.calculate(1, 0.000_001)));
    }

    @Test
    void shouldCalculateForPeriodic() {
        final TgFunc tan = new TgFunc();
        final double expected = 1.9100;
        assertEquals(String.format("%.4f", expected), String.format("%.4f", tan.calculate(134, 0.000_001)));
    }
}
