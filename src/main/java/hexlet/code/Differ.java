package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Differ {

    public static <V> HashMap<String, V> createMapOfValues(String key, V value) {
        var mapOfValues = new HashMap<String, V>();
        mapOfValues.putIfAbsent(key, value);
        return mapOfValues;
    }

    public static <V> String generate(FileToDiffer file1, FileToDiffer file2) {
        var map1 = new HashMap<String, V>(file1.getMapToDiffer());
        var map2 = new HashMap<String, V>(file2.getMapToDiffer());
        var mapOfDiffers = new HashMap<String, ArrayList>();
        var listOfConst = new ArrayList<>();
        var listOfDel = new ArrayList<>();
        var listOfAdd = new ArrayList<>();


        map1.forEach((key, value) -> {
            if (Objects.equals(value, (map2.get(key)))){
                listOfConst.add(createMapOfValues(key, value));
            } else if (!Objects.equals(value, (map2.get(key)))) {
                listOfDel.add(createMapOfValues(key, value));
                var keys = map2.entrySet();
                keys.forEach(e -> e.getKey());
                listOfAdd.add(createMapOfValues(key, (map2.get(key))));
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

    /*public static String generate1(FileToDiffer file1, FileToDiffer file2) {
        var mapOfDiffers = new HashMap<>();
        var map1 = file1.getMapToDiffer();
        var map2 = file2.getMapToDiffer();
        var map2Set = map2.entrySet();
        List listOfConst = map1.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue().equals(second.get(e.getKey()))));





        return mapOfDiffers.toString();
    }*/
}
