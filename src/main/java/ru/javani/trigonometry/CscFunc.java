package ru.javani.trigonometry;

import ru.javani.function.Function;

import static java.lang.String.format;

public class CscFunc implements Function {
    final private SinFunc sin;

    public CscFunc() {
        this.sin = new SinFunc();
    }

    public CscFunc(final SinFunc sin) {
        this.sin = sin;
    }


    @Override
    public double calculate(final double x, final double e) {
        final double s = sin.calculate(x, e);
        if (s == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }
        return 1.0 / s;
    }
}
