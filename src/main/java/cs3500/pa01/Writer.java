package cs3500.pa01;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Writer {
    private Path outPutPath;

    public Writer(String path) {
        this.outPutPath = Path.of(path);
    }

    public void writeFile(FileType file) {
        try {
            FileWriter myWriter = new FileWriter(outPutPath.toString());
            myWriter.write(file.toString());
            myWriter.close();
            System.out.println("Successfully wrote study guide to " + outPutPath.toString());
        } catch (IOException e) {
            System.out.println(FileSystemReader.errorMessage(e));
            e.printStackTrace();
        }
    }
}
