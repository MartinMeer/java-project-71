package hexlet.code;

public class Differ {

    private final FileToDiffer file1;
    private final FileToDiffer file2;

    public Differ(FileToDiffer file1, FileToDiffer file2) {
        this.file1 = file1;
        this.file2 = file2;
    }


    public String differ(FileToDiffer file1, FileToDiffer file2) {
        var map1 = file1.getMapToDiffer();
        var map2 = file2.getMapToDiffer();
        String result = "";

        return result;


    }




}
