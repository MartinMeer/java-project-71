package hexlet.code.formatters;

import java.io.IOException;
import java.util.Map;
public class Formatter {

    private static final String PLAIN = "plain";
    private static final String STYLISH = "stylish";
    private static final String JSON = "json";

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
            default -> {
                throw new IOException("Wrong output format! \"plain\", \"stylish\" and \"json\" formats only.");
            }
        }
    }
    public static Format switchFormat(Map mapOfDiffers) {
        return new Stylish(mapOfDiffers);
    }
}
