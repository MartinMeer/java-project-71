package hexlet.code;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;

public class File<K, V> {

    @Getter
    private Map<K, V> file;
    @Setter
    private Path path;



    public Map<K, V> parseToMap(Path path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        file = objectMapper.readValue((JsonParser) path, new TypeReference<Map<K, V>>(){});
        return file;

    }
}
