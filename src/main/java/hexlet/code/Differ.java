package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(FileToDiffer file1, FileToDiffer file2) {
        var map1 = file1.getMapToDiffer();
        var map2 = file2.getMapToDiffer();
        var mapOfDiffers = new HashMap<String, List>();
        var listOfConst = new ArrayList<>();
        var listOfDel = new ArrayList<>();
        var listOfAdd = new ArrayList<>();

        map1.forEach((key, value) -> {
            if (map2.containsKey(key) && map2.containsValue(value)){
                listOfConst.add(Map.of(key, value));
            } else if (map2.containsKey(key) & !map2.containsValue(value)) {
                listOfDel.add(Map.of(key, value));
                listOfAdd.add(Map.of(key, map2.get(key)));
            } else if (!map2.containsKey(key)) {
                listOfDel.add(Map.of(key, value));
            }
        });
        map2.forEach((key, value) -> {
            if (!map1.containsKey(key)) {
                listOfAdd.add(Map.of(key, value));
            }
        });
        mapOfDiffers.put("const", listOfConst);
        mapOfDiffers.put("del", listOfDel);
        mapOfDiffers.put("add", listOfAdd);
        return mapOfDiffers.toString();
    }
}
