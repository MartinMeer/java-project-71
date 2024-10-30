package hexlet.code;

import hexlet.code.formatters.Format;

import java.io.IOException;
import java.util.Map;

public final class Differ {


    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Parser parser1 = new Parser(filepath1);
        Parser parser2 = new Parser(filepath2);
        Map file1 = parser1.parse();
        Map file2 = parser2.parse();
        Comparator comparator = new Comparator(file1, file2);
        Map mapOfDiffers = comparator.makeMapOfDiff();
        Format formatter = Formatter.switchFormat(format, mapOfDiffers);
        return formatter.toFormat();
    }
    public static String generate(String filepath1, String filepath2) throws IOException {
        String formatName = "stylish";
        return generate(filepath1, filepath2, formatName);
    }
}
