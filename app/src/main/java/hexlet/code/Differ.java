package hexlet.code;

import hexlet.code.formatters.Format;
import hexlet.code.formatters.Formatter;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static hexlet.code.Comparator.makeMapOfDiff;

public class Differ {

    private static Map mapOfDiffers;

    private String filepath1;
    private File inputFile1 = new File(filepath1);
    private String filepath2;
    private File inputFile2 = new File(filepath2);

    public Differ(String filepath1, String filepath2) {
        this.filepath1 = filepath1;
        this.filepath2 = filepath2;
    }

    @Getter
    private static Format formatter;
    private static FileToDiffer file1;
    private static FileToDiffer file2;
    private static String formatName;


    public static String generate(String filepath1, String filepath2) throws IOException {

        formatName = "stylish";
        mapOfDiffers = makeMapOfDiff(file1, file2);
        formatter = Formatter.switchFormat(formatName, mapOfDiffers);
        return formatter.toFormat();
    }
    public static String generate(String filepath1, String filepath2, String formatName) throws IOException {
        file1 = new FileToDiffer<>(filepath1);
        file2 = new FileToDiffer<>(filepath2);
        mapOfDiffers = makeMapOfDiff(file1, file2);
        formatter = Formatter.switchFormat(formatName, mapOfDiffers);
        return formatter.toFormat();
    }
}
