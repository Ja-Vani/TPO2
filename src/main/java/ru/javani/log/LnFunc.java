package ru.javani.log;

import ru.javani.function.*;

public class LnFunc implements Function{

    @Override
    public double calculate(final double x, final double e){
        final double xNew = x-1;
        double tmp;
        double ans = 0;
        double i = 0;
        do {
            tmp = Math.pow(-1, i) * Math.pow(xNew, i + 1) / (i + 1);
            ans += tmp;
            i++;
        }
        while (Math.abs(tmp) > e);
        return ans;
    }
}