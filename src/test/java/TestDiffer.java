import hexlet.code.Differ;
import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    static FileToDiffer file1;
    static FileToDiffer file2;

    @BeforeAll
    public static void setUp() throws IOException {
        file1 = new FileToDiffer<>("src/main/resources/file1.json");
        file2 = new FileToDiffer<>("src/main/resources/file2.json");

    }

    @Test
    public void testDiffer() {
        String expected = "{add=[{timeout=20}, {verbose=true}], const=[{host=hexlet.io}], del=[{timeout=50}, {proxy=123.234.53.22}, {follow=false}]}";
        String actual = Differ.generate(file1, file2);
        assertEquals(actual, expected);

    }
}
