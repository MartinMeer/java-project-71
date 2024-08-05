package hexlet.code;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileToDiffer<K, V> {

    @Getter
    private final Map<K, V> mapToDiffer;
    @Setter
    private String path;

    public FileToDiffer(String path) throws IOException {
        this.path = path;
        File file = new File(path);
        String[] splittedFileType = path.split("\\.");
        String fileType = splittedFileType[splittedFileType.length - 1];
        switch (fileType) {
            case "json" -> this.mapToDiffer = new HashMap<>(Parser.jsonMapper(file));
            case ("yml"), ("yaml") -> this.mapToDiffer = new HashMap<>(Parser.yamlMapper(file));
            default -> throw new IOException("Unsupported format.");
        }
    }
}
