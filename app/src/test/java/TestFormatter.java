import hexlet.code.DifferMaker;
import hexlet.code.FileToDiffer;
import hexlet.code.formatters.Format;
import hexlet.code.formatters.Formatter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormatter {

    private static Map mapOfDiffers;
    static FileToDiffer file1;
    static FileToDiffer file2;
    private static Format formatter;
    static String actual;
    static String expected;
    static Path pathToExpected;
    String format;

    @BeforeAll
    public static void setUp() throws IOException {
        file1 = new FileToDiffer<>("src/test/resources/fixtures/file1.yml");
        file2 = new FileToDiffer<>("src/test/resources/fixtures/file2.yml");
        mapOfDiffers = DifferMaker.makeMapOfDiff(file1, file2);
    }

    @Test
    public void testPlain() throws IOException {
        format = "plain";
        formatter = Formatter.switchFormat(format, mapOfDiffers);
        pathToExpected = Path.of("src/test/resources/fixtures/result_plain.txt");
        actual = formatter.toFormat();
        expected = Files.readString(pathToExpected);
        assertEquals(expected, actual);
    }

    @Test
    public void testStylish() throws IOException {
        format = "stylish";
        formatter = Formatter.switchFormat(format, mapOfDiffers);
        pathToExpected = Path.of("src/test/resources/fixtures/result_stylish.txt");
        actual = formatter.toFormat();
        expected = Files.readString(pathToExpected);
        assertEquals(expected, actual);
    }

    @Test
    public void testJson() throws IOException {
        format = "json";
        formatter = Formatter.switchFormat(format, mapOfDiffers);
        pathToExpected = Path.of("src/test/resources/fixtures/result_json.json");
        actual = formatter.toFormat();
        expected = Files.readString(pathToExpected);
        assertEquals(expected, actual);
    }
}
