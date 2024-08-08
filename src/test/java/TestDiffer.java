import hexlet.code.Differ;
import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    static FileToDiffer file1;
    static FileToDiffer file2;

    @Test
    public void testDifferJSON() throws IOException {
        file1 = new FileToDiffer<>("src/test/resources/file1.json");
        file2 = new FileToDiffer<>("src/test/resources/file2.json");
        String expected = "{add=[{timeout=20}, {verbose=true}], const=[{host=hexlet.io}], del=[{timeout=50}, {proxy=123.234.53.22}, {follow=false}]}";
        String actual = String.valueOf(Differ.collectMapOfDiffers(file1, file2));
        assertEquals(actual, expected);
    }

    @Test
    public void testDifferYAML() throws IOException {
        file1 = new FileToDiffer<>("src/test/resources/file1.yaml");
        file2 = new FileToDiffer<>("src/test/resources/file2.yaml");
        String expected = "{add=[{timeout=20}, {verbose=true}], const=[{host=hexlet.io}], del=[{timeout=50}, {proxy=123.234.53.22}, {follow=false}]}";
        String actual = String.valueOf(Differ.collectMapOfDiffers(file1, file2));
        assertEquals(actual, expected);
    }
    @Test
    public void testDifferYML() throws IOException {
        file1 = new FileToDiffer<>("src/test/resources/file1.yml");
        file2 = new FileToDiffer<>("src/test/resources/file2.yml");
        String expected = "{add=[{timeout=20}, {verbose=true}], const=[{host=hexlet.io}], del=[{timeout=50}, {proxy=123.234.53.22}, {follow=false}]}";
        String actual = String.valueOf(Differ.collectMapOfDiffers(file1, file2));
        assertEquals(actual, expected);
    }
}
