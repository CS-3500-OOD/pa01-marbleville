package cs3500.pa01;

import java.util.ArrayList;
import java.util.Date;

public class MarkDown extends FileType {
  ArrayList<MarkDownUnit> listOfMD;

  public MarkDown(String name, Date created, Date lastModified) {
    this.name = name;
    this.created = created;
    this.lastModified = lastModified;
    this.listOfMD = new ArrayList<MarkDownUnit>();
  }

    /**
     * Adds a MarkDownUnit to the list of MarkDownUnits of this MarkDown
     *
     * @param mdUnit the MarkDownUnit to be added
     */
    public void addMDUnit(MarkDownUnit mdUnit) {
      this.listOfMD.add(mdUnit);
    }

    public void tokenizeLine (String line) {
      String[] lineArray = line.split("]]");
      for (String s : lineArray) {
        this.addMDUnit(MarkDownUnit.stringToMarkDownUnit(s));
      }
    }

    public String toString() {
      StringBuilder result = new StringBuilder();
      for (MarkDownUnit mdUnit : this.listOfMD) {
        result.append(mdUnit.toString());
      }
      return result.toString();
    }
}
