package hexlet.code;

import java.util.HashMap;
import java.util.TreeMap;

public class Comparator {
    public static <V> HashMap<String, TreeMap<String, V>> makeMapOfDiff(FileToDiffer<V> file1, FileToDiffer<V> file2) {
        var map1 = new HashMap<>(file1.getMapToDiffer()).entrySet();
        var map2 = new HashMap<>(file2.getMapToDiffer()).entrySet();

        var mapOfDiffers = new HashMap<String, TreeMap<String, V>>();

        TreeMap<String, V> matched = map1.stream()
                .filter(map2::contains)
                .collect(TreeMap::new, (result, entry)
                        -> result.put(entry.getKey(), entry.getValue()), TreeMap::putAll);

        TreeMap<String, V> removed = map1.stream()
                .filter(e -> !map2.contains(e))
                .collect(TreeMap::new, (result, entry)
                        -> result.put(entry.getKey(), entry.getValue()), TreeMap::putAll);

        TreeMap<String, V> added = map2.stream()
                .filter(e -> !map1.contains(e))
                .collect(TreeMap::new, (result, entry)
                        -> result.put(entry.getKey(), entry.getValue()), TreeMap::putAll);

        mapOfDiffers.put("matched", matched);
        mapOfDiffers.put("removed", removed);
        mapOfDiffers.put("added", added);
        return mapOfDiffers;
    }
}
