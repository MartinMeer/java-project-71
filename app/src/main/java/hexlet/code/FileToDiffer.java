package hexlet.code;

import lombok.Getter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class FileToDiffer<V> {

    private final Map<String, V> mapToDiffer;

    public FileToDiffer(String path) throws IOException {
        this.mapToDiffer = switchParser(path);
    }

    private Map<String, V> switchParser(String path) throws IOException {
        File file = new File(path);
        String[] splittedFileType = path.split("\\.");
        String fileType = splittedFileType[splittedFileType.length - 1];
        switch (fileType) {
            case "json" -> {
                return new HashMap<>(Parser.jsonMapper(file));
            }
            case ("yml"), ("yaml") -> {
                return new HashMap<>(Parser.yamlMapper(file));
            }
            default -> throw new IOException("Unsupported file format. JSON and YAML formats only.");
        }
    }
}
