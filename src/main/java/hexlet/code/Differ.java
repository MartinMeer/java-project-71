package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Differ {

    public static <K, V> HashMap<K, V> createMapOfValues(K key, V value) {
        var mapOfValues = new HashMap<K, V>();
        mapOfValues.put(key, value);
        return mapOfValues;
    }

    public static String generate(FileToDiffer file1, FileToDiffer file2) {
        var map1 = file1.getMapToDiffer();
        var map2 = file2.getMapToDiffer();
        var mapOfDiffers = new HashMap<String, ArrayList>();
        var listOfConst = new ArrayList<>();
        var listOfDel = new ArrayList<>();
        var listOfAdd = new ArrayList<>();

        map1.forEach((key, value) -> {
            if (map2.containsKey(key) && map2.containsValue(value)){
                listOfConst.add(createMapOfValues(key, value));
            } else if (map2.containsKey(key) & !map2.containsValue(value)) {
                listOfDel.add(createMapOfValues(key, value));
                listOfAdd.add(createMapOfValues(key, value));
            } else if (!map2.containsKey(key)) {
                listOfDel.add(createMapOfValues(key, value));
            }
        });
        map2.forEach((key, value) -> {
            if (!map1.containsKey(key)) {
                listOfAdd.add(createMapOfValues(key, value));
            }
        });
        mapOfDiffers.put("const", listOfConst);
        mapOfDiffers.put("del", listOfDel);
        mapOfDiffers.put("add", listOfAdd);
        return mapOfDiffers.toString();
    }

    public static <K, V> String generate1(FileToDiffer file1, FileToDiffer file2) {
        var mapOfDiffers = new HashMap<K, V>();
        var map1 = file1.getMapToDiffer();
        var map2 = file2.getMapToDiffer();
        var map2Set = map2.entrySet();
        List listOfConst = map1.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue().equals(second.get(e.getKey()))));





        return mapOfDiffers.toString();
    }
}
