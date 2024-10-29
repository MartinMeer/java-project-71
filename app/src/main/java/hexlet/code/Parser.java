package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class Parser<V> {

    private final String filepath;
    private String fileType;

    public Parser(String filepath) {
        this.filepath = filepath;
    }

    private void trimFileType() {
        String[] splittedFileType = filepath.split("\\.");
        fileType = splittedFileType[splittedFileType.length - 1];
    }

    public Map<String, V> parse () throws IOException {
        trimFileType();
        File file = new File(filepath);
        switch (fileType) {
            case "json" -> {
                return new HashMap<>(jsonMapper(file));
            }
            case ("yml"), ("yaml") -> {
                return new HashMap<>(yamlMapper(file));
            }
            default -> throw new IOException("Unsupported file format. JSON and YAML formats only.");
        }
    }

    private Map<String, V> jsonMapper(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<>() { });
    }

    private Map<String, V> yamlMapper(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        return objectMapper.readValue(file, new TypeReference<>() { });
    }




}
