package ru.javani.log;

import static java.lang.String.format;

import ru.javani.function.Function;

public class LogFunc implements Function {
    double base;
    LnFunc ln;

    public LogFunc(final double base) {
        this.base = base;
        ln = new LnFunc();
    }

    public LogFunc(final LnFunc ln, final double base) {
        this.base = base;
        this.ln = ln;
    }

    @Override
    public double calculate(final double x, final double e) {
        if (x <= 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }
        return ln.calculate(x, e) / ln.calculate(base, e);
    }
}