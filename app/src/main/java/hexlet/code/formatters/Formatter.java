package hexlet.code.formatters;

import java.util.Map;
public class Formatter {

    private static final String PLAIN = "plain";
    private static final String STYLISH = "stylish";
    private static final String JSON = "json";

    public static Format switchFormat(String format, Map mapOfDiffers) {
        switch (format) {
            case "plain" -> {
                return new Plain(mapOfDiffers);
            }
            case "json" -> {
                return new Json(mapOfDiffers);
            }
            default -> {
                return new Stylish(mapOfDiffers);
            }
        }
    }
    public static Format switchFormat(Map mapOfDiffers) {
        return new Stylish(mapOfDiffers);
    }
}
