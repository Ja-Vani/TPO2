package ru.javani;

import ru.javani.function.Function;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVWriter {
    public static void write(
            final String filename,
            final Function function,
            final double from,
            final double to,
            final double step,
            final double precision)
            throws IOException {
        final Path path = Paths.get(filename);
        final File file = new File(path.toUri());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (double current = from; current <= to; current += step) {
                printWriter.println(current + "," + function.calculate(current, precision));
            }
        }
    }
}
