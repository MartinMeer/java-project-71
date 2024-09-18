package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Format {
    String toFormat() throws JsonProcessingException;
}
