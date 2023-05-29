package ru.javani.trigonometry;

import ru.javani.function.Function;

public class CosFunc implements Function {

    private final SinFunc sin;

    public CosFunc() {
        this.sin = new SinFunc();
    }

    public CosFunc(final SinFunc sin) {
        this.sin = sin;
    }


    @Override
    public double calculate(final double x, final double e) {
        if (x == 0) {
            return 1;
        } else if (x == Math.PI / 2) {
            return 0;
        }
        return Math.sqrt(Math.abs(1.0 - Math.pow(sin.calculate(x, e), 2.0)));
    }
}
