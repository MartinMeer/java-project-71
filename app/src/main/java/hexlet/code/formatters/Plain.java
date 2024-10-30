package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Plain<T> implements Format {

    private final Map<String, TreeMap<String, T>> mapOfDiffers;

    public Plain(Map<String, TreeMap<String, T>> mapOfDiffers) {
        this.mapOfDiffers = mapOfDiffers;
    }

    @Override
    public String toFormat() {

        StringBuilder formattedDiffer = new StringBuilder();
        String prefix = "Property '";
        List<String> unsortedString = new ArrayList<>();

        TreeMap<String, String> addedKV = extractMapOfStrings("added");
        TreeMap<String, String> removedKV = extractMapOfStrings("removed");
        removedKV.entrySet().stream()
                .filter(entry -> addedKV.containsKey(entry.getKey()))
                .forEach(entry -> {
                    String patternUpdated = entry.getKey()
                            + "' was updated. From " + entry.getValue()
                            + " to " + addedKV.get(entry.getKey()) + "\n";
                    unsortedString.add(patternUpdated);
                });
        removedKV.entrySet().stream()
                .filter(entry -> !addedKV.containsKey(entry.getKey()))
                .forEach(entry -> {
                    String patternRemoved = entry.getKey() + "' was removed\n";
                    unsortedString.add(patternRemoved);
                });
        addedKV.entrySet().stream()
                .filter(entry -> !removedKV.containsKey(entry.getKey()))
                .forEach(entry -> {
                    String patternAdded = entry.getKey()
                            + "' was added with value: "
                            + entry.getValue() + "\n";
                    unsortedString.add(patternAdded);
                });
        unsortedString.stream()
                .sorted()
                .forEach(element -> formattedDiffer.append(prefix).append(element));
        return formattedDiffer.toString().trim();
    }

    private TreeMap<String, String> extractMapOfStrings(String key) {
        var extractedMap = mapOfDiffers.get(key);
        String complexValue = "[complex value]";
        TreeMap<String, String> mapOfStrings = new TreeMap<>();
        extractedMap.entrySet().forEach(entry -> {
            if (entry.getValue() instanceof Iterable<?> || entry.getValue() instanceof Map) {
                mapOfStrings.put(entry.getKey(), complexValue);
            } else if (entry.getValue() instanceof String) {
                String value = "'" + entry.getValue() + "'";
                mapOfStrings.put(entry.getKey(), value);
            } else {
                mapOfStrings.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        });
        return mapOfStrings;
    }
}
