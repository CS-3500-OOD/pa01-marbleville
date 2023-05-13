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
     * Parses a string into a FileType object
     *
     * @param file     the string to be parsed
     * @param attr     the attributes of the file
     * @param fileName the name of the file
     * @return A FileType object with the data from the given string
     */
    public abstract FileType parseFile(String file, BasicFileAttributes attr, String fileName);

    /**
     * Calls parseFile on the correct FIleType based on the given file
     *
     * @param file     the string to be parsed
     * @param attr     the attributes of the file
     * @param fileName the name of the file
     * @return A FileType object with the data from the given string
     */
    public static FileType getFile(String file, BasicFileAttributes attr, String fileName) {
        switch (fileName.substring(fileName.lastIndexOf(".") + 1)) {
            case "md":
                return new MarkDown(fileName, attr.creationTime(),
                    attr.lastModifiedTime()).parseFile(file, attr, fileName);
            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }

    public abstract ArrayList<FileUnit> getUnits();
}
