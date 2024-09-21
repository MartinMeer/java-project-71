import hexlet.code.Differ;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormatter {

    private static Map mapOfDiffers;
    static FileToDiffer file1;
    static FileToDiffer file2;
    private static Format formatter;
    static String actual;
    static String expected;
    static Path pathToExpected;

    static String format;
    static String diff;
    static String filepath1;
    static String filepath2;
    static String[] fileType = {"yml", "yaml", "json", "smth"};


    public static void setUpYml() {
        filepath1 = "src/test/resources/fixtures/file1.yml";
        filepath2 = "src/test/resources/fixtures/file2.yml";
    }
    public static void setUpYaml() {
        filepath1 = "src/test/resources/fixtures/file1.yaml";
        filepath2 = "src/test/resources/fixtures/file2.yaml";
    }
    public static void setUpJson() {
        filepath1 = "src/test/resources/fixtures/file1.json";
        filepath2 = "src/test/resources/fixtures/file2.json";
    }
    public static void callCli(String inputFileType) throws IOException {
        inputFileType = fileType;
        if (inputFileType.equals("yml")) {
            setUpYml();
        } else if (inputFileType.equals("yaml")) {
            setUpYaml();
        } else if (inputFileType.equals("json")) {
            setUpJson();
        }
        Differ.setFormat(format);
        diff = Differ.generate(filepath1, filepath2);
    }

    @Test
    public void testPlain() throws IOException {
        format = "plain";
        fileType = "yml";
        callCli(fileType);

        expected = Files.readString(pathToExpected);
        assertThat();
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
