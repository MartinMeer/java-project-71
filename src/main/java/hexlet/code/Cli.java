package hexlet.code;
import java.util.concurrent.Callable;

import static picocli.CommandLine.*;

/*Usage: gendiff [-hV]
Compares two configuration files and shows a difference.
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.*/

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class Cli implements Callable {

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;


    @Override
    public Object call() throws Exception {


        return null;
    }
}
