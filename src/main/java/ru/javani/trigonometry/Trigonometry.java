package ru.javani;

public class Trigonometry{
    public static double fact(final double x) {
        if (x > 0) {
            return x * fact(x - 1);
        } else {
            return 1;
        }
    }

    public static double sin(final double x) {
        double tmp;
        double ans = 0;
        double i = 0;
        do {
            tmp = Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / fact(2 * i + 1);
            ans += tmp;
            i++;
        }
        while (Math.abs(tmp) > 0.001);
        return ans;
    }

    public static double cos(final double x) {
        return Math.sqrt(1.0-Math.pow(sin(x), 2));
    }

    public static double csc(final double x) {
        return 1.0/sin(x);
    }

    public static double sec(final double x){
        return 1.0/cos(x);
    }

    public static double tg(final double x){
        return sin(x)/cos(x);
    }
}