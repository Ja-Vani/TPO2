package ru.javani.trigonometry;

import ru.javani.function.Function;

import static java.lang.String.format;

public class TgFunc implements Function {
    final private SinFunc sin;
    final private CosFunc cos;

    public TgFunc() {
        this.sin = new SinFunc();
        this.cos = new CosFunc();
    }

    public TgFunc(final SinFunc sin, final CosFunc cos) {
        this.sin = sin;
        this.cos = cos;
    }


    @Override
    public double calculate(final double x,final double e) {
        final double c = cos.calculate(x, e);
        if (c == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }
        return sin.calculate(x, e) / c;
    }
}
