package cs3500.pa01;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;

public class MarkDown extends FileType {
  private ArrayList<MarkDownUnit> listOfMD = new ArrayList<>();

  public MarkDown(String name, FileTime created, FileTime lastModified) {
    super(name, created, lastModified);
  }

  /**
   * Parses a string into a MarkDown object
   *
   * @param file the string to be parsed
   * @return A MarkDown object with the data from the given string
   */
  public void parseFile(String file) {
    String[] mdArray = file.split("\n");
    for (int i = 0; i < mdArray.length; i++) {
      String line = mdArray[i];
      // If a line contains "[[" but not "]]", then it is a point that spans multiple lines
      // and must be put together
      if (line.contains("[[") && !line.contains("]]")) {
        line = mdArray[i] + mdArray[i + 1];
        i++;
      }
      this.tokenizeLine(line);
    }
  }

  /**
   * Adds a MarkDownUnit to the list of MarkDownUnits of this MarkDown
   *
   * @param mdUnit the MarkDownUnit to be added
   */
  public void addMDUnit(MarkDownUnit mdUnit) {
    this.listOfMD.add(mdUnit);
  }

  /**
   * Tokenizes a line of text into MarkDownUnits and adds them to the list of MarkDownUnits
   *
   * @param line to be tokenized
   */
  public void tokenizeLine(String line) {
    String[] lineArray = line.split("]]");
    for (String s : lineArray) {
      if (s.contains("[[")) {
        s = s.substring(s.indexOf("[["));
        s += "]]";
      }
      if (s.startsWith("#") || s.startsWith("[[")) {
        this.addMDUnit(MarkDownUnit.stringToMarkDownUnit(s));
      }
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < this.listOfMD.size(); i++) {

      if (i == listOfMD.size() - 1 || listOfMD.get(i + 1).getTag().contains("#")) {
        String unitString = this.listOfMD.get(i).toString() + "\n";
        result.append(unitString);
      } else {
        String unitString = this.listOfMD.get(i).toString();
        result.append(unitString);
      }
    }
    return result.toString();
  }

  public ArrayList<MarkDownUnit> getUnits() {
    return this.listOfMD;
  }
}
