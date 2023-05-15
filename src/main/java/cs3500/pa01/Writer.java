package cs3500.pa01;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Writes a file to the given path.
 */
public class Writer {
  private Path outPutPath;

  /**
   * Constructs a Writer object
   *
   * @param path the path to write the file to
   */
  public Writer(String path) {
    this.outPutPath = Path.of(path);
  }

  /**
   * Writes a file to the given path
   *
   * @param file the file to be written
   */
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
