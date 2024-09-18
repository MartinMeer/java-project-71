import hexlet.code.FileToDiffer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestFileToDiffer {

    FileToDiffer file;

    @Test
    public void testMapFromJSON() throws IOException {
        file = new FileToDiffer<>("src/test/resources/file1.json");
        Map<String, String> expected = Map.of(
                "host", "hexlet.io",
                "timeout", "50",
                "proxy", "123.234.53.22",
                "follow", "false");
        var actual = file.getMapToDiffer();

        assert (actual.size() == expected.size());
        assert (actual.containsKey("host"));
        assert (actual.containsValue("123.234.53.22"));
        assert (actual.get("proxy").equals("123.234.53.22"));
    }

    @Test
    public void testMapWithNullKeyByHashMap() throws IOException {
        file = new FileToDiffer<>("src/test/resources/fileWithNullValue.json");
        var expected = new HashMap<>();
        expected.put("host", null);
        expected.put("path", "file");
        var actual = file.getMapToDiffer();

        assert (actual.size() == expected.size());
        assert (actual.containsKey("host"));
        assert (actual.containsValue(null));
        assert (actual.containsKey("path"));
        assert (actual.containsValue("file"));
    }


}
