import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class TestFileToDiffer {

    FileToDiffer file;

    @BeforeEach
    public void setUp() {
        file = new FileToDiffer<>("src/test/resources/file1.json");
    }

    @Test
    public void testMap() throws IOException {
        Map<String, String> expected = Map.of(
                "host", "hexlet.io",
                "timeout", "50",
                "proxy", "123.234.53.22",
                "follow", "false");
        assert(file.parseToMap().containsKey("host"));
        assert(file.parseToMap().size() == expected.size());
        assert(file.parseToMap().containsValue("123.234.53.22"));
        assert(file.parseToMap().get("proxy").equals("123.234.53.22"));

    }
}
