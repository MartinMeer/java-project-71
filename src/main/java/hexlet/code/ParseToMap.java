package hexlet.code;

import java.nio.file.Path;
import java.util.Map;

public interface ParseToMap<K, V> {
    public Map<K, V> parseToMap(Path path);
}
