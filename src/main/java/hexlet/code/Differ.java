package hexlet.code;

import hexlet.code.formatters.Formatter;
import hexlet.code.formatters.Plain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Differ {

    private static Map mapOfDiffers;

    public static String generate(FileToDiffer file1, FileToDiffer file2, Formatter format) {
        Formatter formatter = new Plain(format);
        var mapOfDiffers = collectMapOfDiffers(file1, file2);
        String differ = formatter.toFormat(mapOfDiffers);
        return differ;
    }

    public static <V> HashMap<String, List> collectMapOfDiffers(FileToDiffer file1, FileToDiffer file2) {
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
        return mapOfDiffers;
    }
}
