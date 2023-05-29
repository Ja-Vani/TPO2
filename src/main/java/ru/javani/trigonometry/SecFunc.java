package ru.javani.trigonometry;

import ru.javani.function.Function;

import static java.lang.String.format;

public class SecFunc implements Function {
    final private CosFunc cos;

    public SecFunc() {
        this.cos = new CosFunc();
    }

    public SecFunc(final CosFunc cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(final double x, final double e) {
        final double c = cos.calculate(x, e);
        if (c == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }
        return 1.0 / c;
    }
}
