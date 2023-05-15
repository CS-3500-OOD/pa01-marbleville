package cs3500.pa01;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class FileType {
  private String name;
  private FileTime created;
  private FileTime lastModified;

  public FileType(String name, FileTime created, FileTime lastModified) {
    this.name = name;
    this.created = created;
    this.lastModified = lastModified;
  }

  /**
   * Returns the name of this MarkDown
   *
   * @return the name of this MarkDown
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the created date of this MarkDown
   *
   * @return the created date of this MarkDown
   */
  public FileTime getCreated() {
    return this.created;
  }

  /**
   * Returns the last modified date of this MarkDown
   *
   * @return the last modified date of this MarkDown
   */
  public FileTime getLastModified() {
    return this.lastModified;
  }

  /**
   * Returns the string representation of this MarkDown
   *
   * @return the string representation of this MarkDown
   */
  public abstract String toString();

  /**
   * Adds data from a string to a FileType object
   *
   * @param file the string to be parsed
   * @return A FileType object with the data from the given string
   */
  public abstract void parseFile(String file);
}
