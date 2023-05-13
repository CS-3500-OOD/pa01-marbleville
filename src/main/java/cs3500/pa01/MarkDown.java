package cs3500.pa01;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;

public class MarkDown extends FileType {
    private ArrayList<FileUnit> listOfMD = new ArrayList<>();

    public MarkDown(String name, FileTime created, FileTime lastModified) {
        super(name, created, lastModified);
    }

    /**
     * Parses a string into a MarkDown object
     *
     * @param file     the string to be parsed
     * @param attr     the attributes of the file
     * @param fileName the name of the file
     * @return A MarkDown object with the data from the given string
     */
    public MarkDown parseFile(String file, BasicFileAttributes attr, String fileName) {
        String[] mdArray = file.split("\n");
        MarkDown markDown = new MarkDown(fileName, attr.creationTime(), attr.lastModifiedTime());
        for (String line : mdArray) {
            markDown.tokenizeLine(line);
        }
        return markDown;
    }

    /**
     * Adds a MarkDownUnit to the list of MarkDownUnits of this MarkDown
     *
     * @param mdUnit the MarkDownUnit to be added
     */
    public void addMDUnit(FileUnit mdUnit) {
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
            if (s.startsWith("[[")) {
                s += "]]";
            }
            if (s.startsWith("#") || s.startsWith("[[")) {
                this.addMDUnit(MarkDownUnit.stringToMarkDownUnit(s));
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (FileUnit mdUnit : this.listOfMD) {
            result.append(mdUnit.toString());
        }
        return result.toString();
    }

    public ArrayList<FileUnit> getUnits() {
        return this.listOfMD;
    }
}
