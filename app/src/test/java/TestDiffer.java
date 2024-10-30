import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDiffer {

    private static String expected;
    private static Path pathToExpected;
    private static String formatName = "stylish";
    private static String diff;
    private static String filepath1;
    private static String filepath2;
    private Exception expectedEx;

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
    public static void setUpUnsupported() {
        filepath1 = "src/test/resources/fixtures/file1.xml";
        filepath2 = "src/test/resources/fixtures/file2.xml";
    }
    public static void callDiffer(String inputFileType) throws IOException {
        if (inputFileType.equals("yml")) {
            setUpYml();
        } else if (inputFileType.equals("yaml")) {
            setUpYaml();
        } else if (inputFileType.equals("json")) {
            setUpJson();
        } else if (inputFileType.equals("unsupported")) {
            setUpUnsupported();
        }
        diff = Differ.generate(filepath1, filepath2, formatName);
    }

    @Test
    public void testPlain() throws IOException {
        formatName = "plain";
        pathToExpected = Path.of("src/test/resources/fixtures/result_plain.txt");
        expected = Files.readString(pathToExpected);
        callDiffer("yml");
        assertEquals(expected, diff);
        callDiffer("yaml");
        assertEquals(expected, diff);
        callDiffer("json");
        assertEquals(expected, diff);
    }

    @Test
    public void testStylish() throws IOException {
        formatName = "stylish";
        pathToExpected = Path.of("src/test/resources/fixtures/result_stylish.txt");
        expected = Files.readString(pathToExpected);
        callDiffer("yml");
        assertEquals(expected, diff);
        callDiffer("yaml");
        assertEquals(expected, diff);
        callDiffer("json");
        assertEquals(expected, diff);
    }

    @Test
    public void testJson() throws IOException {
        formatName = "json";
        pathToExpected = Path.of("src/test/resources/fixtures/result_json.json");
        expected = Files.readString(pathToExpected);
        callDiffer("yml");
        assertEquals(expected, diff);
        callDiffer("yaml");
        assertEquals(expected, diff);
        callDiffer("json");
        assertEquals(expected, diff);
    }
    @Test
    public void testDefault() throws IOException {
        pathToExpected = Path.of("src/test/resources/fixtures/result_stylish.txt");
        expected = Files.readString(pathToExpected);
        setUpJson();
        diff = Differ.generate(filepath1, filepath2);
        assertEquals(expected, diff);
    }

    @Test
    public void testWrongFormatInput() {
        formatName = "smth";
        expected = "Wrong output format! \"plain\", \"stylish\" and \"json\" formats only.";
        expectedEx = assertThrows(IOException.class, () -> callDiffer("yml"));
        assertEquals(expected, expectedEx.getMessage());
    }
    @Test
    public void testWrongFileInput() {
        expectedEx = assertThrows(IOException.class, () -> callDiffer("unsupported"));
        expected = "Unsupported file format. JSON and YAML formats only.";
        assertEquals(expected, expectedEx.getMessage());
    }

    @Test
    public void testDiffer() throws IOException {
        setUpJson();
        pathToExpected = Path.of("src/test/resources/fixtures/result_stylish.txt");
        expected = Files.readString(pathToExpected);
        diff = Differ.generate(filepath1, filepath2);
        assertEquals(expected, diff);
    }
}
