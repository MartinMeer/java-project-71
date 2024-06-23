package hexlet.code;
import static picocli.CommandLine.*;

/*Usage: gendiff [-hV]
Compares two configuration files and shows a difference.
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.*/

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class Cli implements Runnable {

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    boolean format;

    @Parameters(index = "0", description = "path to first file")
    String filepath1;
    @Parameters(index = "1", description = "path to second file")
    String filepath2;

    public void generate() {
        System.out.println("Generate Differ of two files");
    }

    @Override
    public void run() {

    }
}
