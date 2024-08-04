package hexlet.code;

import picocli.CommandLine;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {
        /*int exitCode = new CommandLine(new Cli()).execute(args);
        System.exit(exitCode);*/
        FileToDiffer file1 = new FileToDiffer<>("src/main/resources/nestedFile1.json");
        FileToDiffer file2 = new FileToDiffer<>("src/main/resources/nestedFile2.json");
        System.out.println(Differ.generate(file1, file2));
    }
}
