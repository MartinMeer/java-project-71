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

}
