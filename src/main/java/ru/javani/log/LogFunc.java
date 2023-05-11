package ru.javani.log;

import ru.javani.function.*;

public class LogFunc implements Function{
    double base;
    LnFunc ln;

    public LogFunc(){
        base = 2;
        ln = new LnFunc();
    }

    public LogFunc(final double base){
        this.base = base;
        ln = new LnFunc();
    }

    @Override
    public double calculate(final double x, final double e){
        return ln.calculate(x, e)/ln.calculate(base, e);
    }
}