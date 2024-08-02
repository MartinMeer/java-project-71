import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class TestFileToDiffer {

    FileToDiffer file;

    @BeforeEach
    public void setUp() throws IOException {
        file = new FileToDiffer<>("src/main/resources/file1.json");
    }



    @Test
    public void testMap() {
        Map<String, String> expected = Map.of(
                "host", "hexlet.io",
                "timeout", "50",
                "proxy", "123.234.53.22",
                "follow", "false");
        var actual = file.getFileToDiffer();

        assert(actual.containsKey("host"));
        assert(actual.size() == expected.size());
        assert(actual.containsValue("123.234.53.22"));
        assert(actual.get("proxy").equals("123.234.53.22"));

    }
}
