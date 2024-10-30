package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;



public final class Comparator<V> {

    private final Map<String, V> file1;
    private final Map<String, V> file2;

    public Comparator(Map<String, V> file1, Map<String, V> file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    public HashMap<String, TreeMap<String, V>> makeMapOfDiff() {
        HashMap<String, TreeMap<String, V>> mapOfDiffers = new HashMap<>();
        var map1 = new HashMap<>(file1).entrySet();
        var map2 = new HashMap<>(file2).entrySet();

        TreeMap<String, V> matched = file1.entrySet().stream()
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
