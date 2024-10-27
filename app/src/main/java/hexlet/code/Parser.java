package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Parser<V> {

    private File file;

    public Parser(File file) {
        this.file = file;
    }

    private Map<String, V> parse (File file) throws IOException {
        String[] splittedFileType = path.split("\\.");
        String fileType = splittedFileType[splittedFileType.length - 1];
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

    public Map<String, V> jsonMapper(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<>() { });
    }

    public Map<String, V> yamlMapper(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        return objectMapper.readValue(file, new TypeReference<>() { });
    }




}
