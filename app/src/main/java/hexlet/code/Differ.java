package hexlet.code;

import hexlet.code.formatters.Format;
import hexlet.code.formatters.Formatter;
import java.io.IOException;
import java.util.Map;

public class Differ {

    private static Format formatter;
    private static Map file1;
    private static Map file2;
    private static Map mapOfDiffers;
    private static String formatName;


    public static String generate(String filepath1, String filepath2, String formatName) throws IOException {
        Parser parser1 = new Parser(filepath1);
        Parser parser2 = new Parser(filepath2);
        file1 = parser1.parse();
        file2 = parser2.parse();
        Comparator comparator = new Comparator(file1, file2);
        mapOfDiffers = comparator.getMapOfDiffers();
        formatter = Formatter.switchFormat(formatName, mapOfDiffers);
        return formatter.toFormat();
    }
    public static String generate(String filepath1, String filepath2) throws IOException {
        formatName = "stylish";
        return generate(filepath1, filepath2, formatName);
    }
}
