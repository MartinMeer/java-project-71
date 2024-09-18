package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class Stylish<V> implements Format {

    private final Map<String, TreeMap<String, V>> mapOfDiffers;

    public Stylish(Map<String, TreeMap<String, V>> mapOfDiffers) {
        this.mapOfDiffers = mapOfDiffers;
    }

    @Override
    public String toFormat() {
        TreeMap<String, String> flattedMapWithSignedKeys = flattenMapWithSignedKeys();
        StringBuilder formattedDiffer = new StringBuilder("{\n");
        flattedMapWithSignedKeys.forEach((key, value) -> {
            String prefix = "";
            String postfix = key.substring(key.length() - 1);
            if (postfix.equals("1")) {
                prefix = "    ";
            } else if (postfix.equals("2")) {
                prefix = "  - ";
            } else if (postfix.equals("3")) {
                prefix = "  + ";
            }
            String keyWithoutPrefix = key.substring(0, key.length() - 1);
            String stringRepresentation = prefix + keyWithoutPrefix + ": " + value + "\n";
            formattedDiffer.append(stringRepresentation);
        });
        return formattedDiffer + "}\n";
    }

    private TreeMap<String, String> flattenMapWithSignedKeys() {
        TreeMap<String, String> flattedMapWithSignedKeys = new TreeMap<>();
        mapOfDiffers.entrySet().forEach(entry -> {
            String postfix = "";
            var key = entry.getKey();
            var valuesOfNestedMap = entry.getValue();
            if (key.equals("matched")) {
                postfix = "1";
            } else if (key.equals("removed")) {
                postfix = "2";
            } else if (key.equals("added")) {
                postfix = "3";
            }
            String keyWithPostfix;
            for (var value : valuesOfNestedMap.entrySet()) {
                keyWithPostfix = value.getKey() + postfix;
                String stringRepresentationOfValue = String.valueOf(value.getValue());
                flattedMapWithSignedKeys.put(keyWithPostfix, stringRepresentationOfValue);
            }
        });
        return flattedMapWithSignedKeys;
    }
}
