package ru.javani;

import java.io.IOException;

import ru.javani.function.SystemFunction;
import ru.javani.log.LnFunc;
import ru.javani.log.LogFunc;
import ru.javani.trigonometry.CosFunc;
import ru.javani.trigonometry.SinFunc;
import ru.javani.trigonometry.TgFunc;

public class AppMain {
    public static void main(final String[] args) throws IOException {
        final CosFunc cos = new CosFunc();
        CSVWriter.write(
                "cos.csv",
                cos,
                -1,
                1,
                0.1,
                0.000_001);

        final SinFunc sin = new SinFunc();
        CSVWriter.write(
                "sin.csv",
                sin,
                -1,
                1,
                0.1,
                0.000_001);

        final TgFunc tan = new TgFunc();
        CSVWriter.write(
                "tan.csv",
                tan,
                -1,
                1,
                0.1,
                0.000_001);

        final LnFunc ln = new LnFunc();
        CSVWriter.write(
                "ln.csv",
                ln,
                0.000_000_000_1,
                2,
                0.1,
                0.000_001);

        final LogFunc log2 = new LogFunc(2);
        CSVWriter.write(
                "log2.csv",
                log2,
                0.000_000_000_1,
                2,
                0.1,
                0.000_001);

        final LogFunc log5 = new LogFunc(5);
        CSVWriter.write(
                "log5.csv",
                log5,
                0.000_000_000_1,
                2,
                0.1,
                0.000_001);

        final LogFunc log10 = new LogFunc(10);
        CSVWriter.write(
                "log10.csv",
                log10,
                0.000_000_000_1,
                2,
                0.1,
                0.000_001);

        final SystemFunction func = new SystemFunction();
        CSVWriter.write(
                "func.csv",
                func,
                -2,
                2,
                0.1,
                0.000_001);
    }
}
