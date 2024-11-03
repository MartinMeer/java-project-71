import hexlet.code.Differ;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestDiffer {

    private static String filepath1;
    private static String filepath2;

    public static Path readFixturePath(String fileName) {
        Path pathToFixture = Paths.get("src/test/resources/fixtures", fileName);
        return pathToFixture.normalize();
    }

    public static void setUpInputFiles(String fileType) {
        filepath1 = readFixturePath("file1." + fileType).toString();
        filepath2 = readFixturePath("file2." + fileType).toString();
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    public void testPlain(String fileType) throws IOException {
        setUpInputFiles(fileType);
        String formatName = "plain";
        Path pathToExpected = readFixturePath("result_plain.txt");
        String expected = Files.readString(pathToExpected);
        String actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    public void testStylish(String fileType) throws IOException {
        setUpInputFiles(fileType);
        String formatName = "stylish";
        Path pathToExpected = readFixturePath("result_stylish.txt");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    public void testJson(String fileType) throws IOException {
        setUpInputFiles(fileType);
        String formatName = "json";
        Path pathToExpected = readFixturePath("result_json.json");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    public void testDefault(String fileType) throws IOException {
        setUpInputFiles(fileType);
        Path pathToExpected = readFixturePath("result_stylish.txt");
        String expected = Files.readString(pathToExpected);
        String actual = Differ.generate(filepath1, filepath2);
        assertEquals(expected, actual);
    }
}
