package ru.javani.function;

import ru.javani.log.LnFunc;
import ru.javani.log.LogFunc;

import ru.javani.trigonometry.CosFunc;
import ru.javani.trigonometry.CscFunc;
import ru.javani.trigonometry.SecFunc;
import ru.javani.trigonometry.TgFunc;

import static java.lang.Math.pow;

public class SystemFunction implements Function {
    final private CosFunc cos;
    final private TgFunc tg;
    final private SecFunc sec;
    final private CscFunc csc;
    final private LogFunc log2;
    final private LogFunc log5;
    final private LogFunc log10;
    final private LnFunc ln;

    public SystemFunction(){
        cos = new CosFunc();
        tg = new TgFunc();
        sec = new SecFunc();
        csc = new CscFunc();
        log2 = new LogFunc(2);
        log5 = new LogFunc(5);
        log10 = new LogFunc(10);
        ln = new LnFunc();
    }

    public double xMoreThan0(final double x, final double e){
        return pow(log2.calculate(x, e)+ log5.calculate(x, e)-ln.calculate(x, e), 3)*(log2.calculate(x, e)-log10.calculate(x, e)) - log2.calculate(x, e) - log2.calculate(x, e) - pow(log5.calculate(x, e), 2);
    }

    public double xLessThan0(final double x, final double e){
        return pow(tg.calculate(x, e)/ tg.calculate(x, e)* sec.calculate(x, e)/ csc.calculate(x, e), 3) - (csc.calculate(x, e)- (csc.calculate(x, e)- csc.calculate(x, e)) - cos.calculate(x, e));
    }

    @Override
    public double calculate(final double x, final double e) {
        if(x<=0){
            return xLessThan0(x, e);
        }else {
            return xMoreThan0(x, e);
        }
    }
}
