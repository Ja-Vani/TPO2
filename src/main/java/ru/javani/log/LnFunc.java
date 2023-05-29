package ru.javani.log;

import static java.lang.String.format;

import ru.javani.function.Function;

public class LnFunc implements Function {

    public double xLess1(final double x, final double e){
        int i = 0;
        double tmp;
        double ans = 0;
        do {
            tmp = Math.pow(-1, i) * Math.pow(x - 1, i + 1) / (i + 1);
            ans += tmp;
            i++;
        }
        while (Math.abs(tmp) > e);
        return ans;
    }

    public double xMore1(final double x, final double e){
        double tmp;
        double ans = 0;
        int i = 0;
        do {
            tmp = Math.pow(-1, i) / Math.pow(x - 1, i + 1) / (i + 1);
            ans += tmp;
            i++;
        }
        while (Math.abs(tmp) > e);
        ans += calculate(x - 1, e);
        return ans;
    }

    @Override
    public double calculate(final double x, final double e){
        if (x <= 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }
        if (x == 1) {
            return 0;
        }
        if (Math.abs(x - 1) <= 1) {
             return xLess1(x, e);
        } else {
            return xMore1(x, e);
        }
    }
}