import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    public static Path readFixturePath(String fileName) {
        Path pathToFixture = Paths.get("src/test/resources/fixtures", fileName);
        return pathToFixture.normalize();
    }

    @Test
    public void testPlainOverJson() throws IOException {
        String filepath1 = readFixturePath("file1.json").toString();
        String filepath2 = readFixturePath("file2.json").toString();
        String formatName = "plain";
        Path pathToExpected = readFixturePath("result_plain.txt");
        String expected = Files.readString(pathToExpected);
        String actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainOverYaml() throws IOException {
        String filepath1 = readFixturePath("file1.yaml").toString();
        String filepath2 = readFixturePath("file2.yml").toString();
        String formatName = "plain";
        Path pathToExpected = readFixturePath("result_plain.txt");
        String expected = Files.readString(pathToExpected);
        String actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @Test
    public void testStylishOverJson() throws IOException {
        String filepath1 = readFixturePath("file1.json").toString();
        String filepath2 = readFixturePath("file2.json").toString();
        String formatName = "stylish";
        Path pathToExpected = readFixturePath("result_stylish.txt");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @Test
    public void testStylishOverYaml() throws IOException {
        String filepath1 = readFixturePath("file1.yaml").toString();
        String filepath2 = readFixturePath("file2.yml").toString();
        String formatName = "stylish";
        Path pathToExpected = readFixturePath("result_stylish.txt");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonOverJson() throws IOException {
        String filepath1 = readFixturePath("file1.json").toString();
        String filepath2 = readFixturePath("file2.json").toString();
        String formatName = "json";
        Path pathToExpected = readFixturePath("result_json.json");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonOverYaml() throws IOException {
        String filepath1 = readFixturePath("file1.yaml").toString();
        String filepath2 = readFixturePath("file2.yml").toString();
        String formatName = "json";
        Path pathToExpected = readFixturePath("result_json.json");
        var expected = Files.readString(pathToExpected);
        var actual = Differ.generate(filepath1, filepath2, formatName);
        assertEquals(expected, actual);
    }


    @Test
    public void testDefault() throws IOException {
        String filepath1 = readFixturePath("file1.yaml").toString();
        String filepath2 = readFixturePath("file2.yml").toString();
        Path pathToExpected = readFixturePath("result_stylish.txt");
        String expected = Files.readString(pathToExpected);
        String actual = Differ.generate(filepath1, filepath2);
        assertEquals(expected, actual);
    }
}
