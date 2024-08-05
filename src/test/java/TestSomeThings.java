import hexlet.code.FileToDiffer;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSomeThings {

    FileToDiffer file1;

    @Test
    public void testSets() throws IOException {
        File file = new File("src/test/resources/nestedFile1.json");
        file1 = new FileToDiffer("src/test/resources/nestedFile1.json");
        var map = Parser.jsonMapper(file);
        var mapSet = file1.getMapToDiffer().entrySet();
        assertEquals(map.size(), mapSet.size());
    }


    private <K, V>Map<K, V> areEqualKeyValues(Map<K, V> first, Map<K, V> second) {
        return (Map<K, V>) first.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue().equals(second.get(e.getKey()))));
    }

    public void whenCompareTwoHashMapKeyValuesUsingStreamAPI_thenSuccess() {
        Map<String, String> asiaCapital3 = new HashMap<String, String>();
        asiaCapital3.put("Japan", "Tokyo");
        asiaCapital3.put("South Korea", "Seoul");
        asiaCapital3.put("China", "Beijing");

        Map<String, String> asiaCapital4 = new HashMap<String, String>();
        asiaCapital4.put("South Korea", "Seoul");
        asiaCapital4.put("Japan", "Osaka");
        asiaCapital4.put("China", "Beijing");

        Map<String, Boolean> result = areEqualKeyValues(asiaCapital3, asiaCapital4);

        assertEquals(3, result.size());
        assertThat(result, hasEntry("Japan", false));
        assertThat(result, hasEntry("South Korea", true));
        assertThat(result, hasEntry("China", true));
    }

}
