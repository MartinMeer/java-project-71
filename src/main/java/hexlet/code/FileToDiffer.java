package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileToDiffer<K, V> {

    @Getter
    private Map<K, V> fileToDiffer;
    @Setter
    private String path;

    public FileToDiffer(String path) {
        this.path = path;
    }


    public Map<K, V> parseToMap() throws IOException {
        File file = new File(path);
        ObjectMapper objectMapper = new ObjectMapper();
        fileToDiffer = objectMapper.readValue(file, new TypeReference<>() {
        });
        return fileToDiffer;
    }
}
