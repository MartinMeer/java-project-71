package hexlet.code;

import java.nio.file.Path;
import java.util.Map;

public class File<K, V> {

    private Map<K, V> file;

    public Map<K, V> getFile() {
        return file;
    }

    public Map<K, V> parseToMap(Path path) {
        Map<K, V> parsed = Map.of();
        return parsed;

    }
}
