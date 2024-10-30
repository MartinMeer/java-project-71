package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public final class Json<T> implements Format {
    private final Map<String, TreeMap<String, T>> mapOfDiffers;

    public Json(Map<String, TreeMap<String, T>> mapOfDiffers) {
        this.mapOfDiffers = mapOfDiffers;
    }

    @Override
    public String toFormat() throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(mapOfDiffers);
        return json;
    }
}
