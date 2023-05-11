package cs3500.pa01;

import java.util.Date;

public abstract class FileType {
  String name;
  Date created;
  Date lastModified;

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
  public Date getCreated() {
    return this.created;
  }

  /**
   * Returns the last modified date of this MarkDown
   *
   * @return the last modified date of this MarkDown
   */
  public Date getLastModified() {
    return this.lastModified;
  }
}
