package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;

/*Usage: gendiff [-hV]
Compares two configuration files and shows a difference.
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.*/

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class Cli implements Callable {

    @CommandLine.Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]")
    private String formatName = "stylish";

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Override
    public Object call() throws Exception {
        String diff = Differ.generate(filepath1, filepath2, formatName);
        System.out.println(diff);
        return null;
    }
}
