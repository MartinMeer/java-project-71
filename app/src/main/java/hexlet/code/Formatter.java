package hexlet.code;
import hexlet.code.formatters.Format;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.Map;

public class Formatter {
    public static Format switchFormat(String format, Map mapOfDiffers) throws IOException {
        switch (format) {
            case "plain" -> {
                return new Plain(mapOfDiffers);
            }
            case "json" -> {
                return new Json(mapOfDiffers);
            }
            case "stylish" -> {
                return new Stylish(mapOfDiffers);
            }
            default -> throw new IOException("Wrong output format! \"plain\", \"stylish\" and \"json\" formats only.");
        }
    }
}
