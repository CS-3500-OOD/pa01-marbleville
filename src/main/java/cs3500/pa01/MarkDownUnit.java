package cs3500.pa01;

import java.lang.reflect.Array;

public class MarkDownUnit implements FileUnit {
    private String text;
    private String tag;

    public MarkDownUnit(String text, String tag) {
        this.text = text;
        if (tag.startsWith("#")) {
            this.tag = tag;
        } else if (tag.startsWith("[[")) {
            this.tag = "[[";
        } else {
            throw new IllegalArgumentException("Invalid tag");
        }
    }

    /**
     * Returns the text of this MarkDownUnit
     *
     * @return the text of this MarkDownUnit
     */
    public String getText() {
        return this.text;
    }

    /**
     * Returns the tag of this MarkDownUnit
     *
     * @return the tag of this MarkDownUnit
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Parses the given string into a MarkDownUnit
     * Assumes only one tag per input string
     *
     * @param s the string to be parsed
     * @return MarkDownUnit with associated text and tags
     */
    public static MarkDownUnit stringToMarkDownUnit(String s) {
        String text = "";
        String tag = "";

        if (s.startsWith("#")) {
            String[] lineArray = s.split(" ");
            tag = lineArray[0];
            text = lineArray[1];
        } else if (s.startsWith("[[")) {
            tag = "[[";
            text = s.substring(s.indexOf("[[") + 2, s.indexOf("]]"));
        } else {
            throw new IllegalArgumentException("Invalid input string");
        }

        return new MarkDownUnit(text, tag);
    }

    /**
     * Returns the string representation of this MarkDownUnit
     *
     * @return string representation of this MarkDownUnit
     */
    public String toString() {
        if (tag.startsWith("#")) {
            return tag + " " + text + "\n\n"; // add extra new line after header
        } else {
            return "- " + text + "\n";
        }
    }
}
