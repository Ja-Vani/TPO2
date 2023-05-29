package ru.javani.trigonometry;

import ru.javani.function.Function;

public class SinFunc implements Function {

    public static double fact(final double x) {
        if (x > 0) {
            return x * fact(x - 1);
        } else {
            return 1;
        }
    }

    @Override
    public double calculate(final double x, final double e) {
        double newX = x;
        if (x >= 0) {
            while (newX > Math.PI * 2) {
                newX -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (newX < Math.PI * 2) {
                newX += Math.PI * 2;
            }
        }

        double tmp;
        double ans = 0;
        double i = 0;
        do {
            tmp = Math.pow(-1, i) * Math.pow(newX, 2 * i + 1) / fact(2 * i + 1);
            ans += tmp;
            i++;
        }
        while (Math.abs(tmp) > 0.001);
        return ans;
    }
}
