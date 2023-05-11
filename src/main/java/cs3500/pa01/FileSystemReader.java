package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileSystemReader<T> {
  ArrayList<T> files = new ArrayList<>();
  Scanner input;
  Path startPath;

  FileSystemReader(String path) {
    this.startPath = Path.of(path);
    try {
      this.input = new Scanner(startPath);
    } catch (IOException err) {
      System.err.println("File not found");
    }
  }

  /**
   * Adds a given file to the list of files
   *
   * @param file to be added
   */
  public void addFile(T file) {
    this.files.add(file);
  }
}
