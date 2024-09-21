import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class TestCli {

    static String expected;
    static Path pathToExpected;
    static String format = "stylish";
    static String diff;
    static String filepath1;
    static String filepath2;

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
        pathToExpected = Path.of("src/test/resources/fixtures/result_plain.txt");
        expected = Files.readString(pathToExpected);
        callCli("yml");
        assertEquals(expected, diff);
        callCli("yaml");
        assertEquals(expected, diff);
        callCli("json");
        assertEquals(expected, diff);
    }

    @Test
    public void testStylish() throws IOException {
        format = "stylish";
        pathToExpected = Path.of("src/test/resources/fixtures/result_stylish.txt");
        expected = Files.readString(pathToExpected);
        callCli("yml");
        assertEquals(expected, diff);
        callCli("yaml");
        assertEquals(expected, diff);
        callCli("json");
        assertEquals(expected, diff);
    }

    @Test
    public void testJson() throws IOException {
        format = "json";
        pathToExpected = Path.of("src/test/resources/fixtures/result_json.json");
        expected = Files.readString(pathToExpected);
        callCli("yml");
        assertEquals(expected, diff);
        callCli("yaml");
        assertEquals(expected, diff);
        callCli("json");
        assertEquals(expected, diff);
    }

    @Test
    public void testWrongFormatInput() throws IOException {
        format = "smth";
        pathToExpected = Path.of("src/test/resources/fixtures/result_json.json");
        Exception expectedEx = assertThrows(IOException.class, () -> callCli("yml"));
        assertEquals("Wrong format! \"plain\", \"stylish\" and \"json\" formats only", expectedEx.getMessage());
    }
}
