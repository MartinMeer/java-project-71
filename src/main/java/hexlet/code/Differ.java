package hexlet.code;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Differ {

    public static <V> String generate(FileToDiffer file1, FileToDiffer file2) {
        var map1 = new HashMap<String, V>(file1.getMapToDiffer()).entrySet();
        var map2 = new HashMap<String, V>(file2.getMapToDiffer()).entrySet();

        var mapOfDiffers = new HashMap<String, List>();

        var matched = List.of(map1.stream()
                .filter(map2::contains)
                .collect(Collectors.toList()));
        var deleted = List.of(map1.stream()
                .filter(e -> !map2.contains(e))
                .collect(Collectors.toList()));

        var added = List.of(map2.stream()
                .filter(e -> !map1.contains(e))
                .collect(Collectors.toList()));

        mapOfDiffers.put("matched", matched);
        mapOfDiffers.put("deleted", deleted);
        mapOfDiffers.put("added", added);
        return mapOfDiffers.toString();
    }
}
