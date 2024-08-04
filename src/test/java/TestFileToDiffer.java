import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class TestFileToDiffer {

    FileToDiffer file;

    @BeforeEach
    public void setUp() throws IOException {
        file = new FileToDiffer<>("src/test/resources/file1.yaml");
    }
    @Test
    public void testMap() {
        Map<String, String> expected = Map.of(
                "host", "hexlet.io",
                "timeout", "50",
                "proxy", "123.234.53.22",
                "follow", "false");
        var actual = file.getMapToDiffer();

        assert(actual.size() == expected.size());
        assert(actual.containsKey("host"));
        assert(actual.containsValue("123.234.53.22"));
        assert(actual.get("proxy").equals("123.234.53.22"));
    }


}
