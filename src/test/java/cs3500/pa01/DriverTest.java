package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class DriverTest {

  /**
   * Tests the main method for Driver
   */
  @Test
  public void testMainWithMarkDownFiles() {
    String[] args = {"src/test/resources", "n", "src/test/studyGuide.md"};
    Driver.main(args);
    StringBuilder sb = new StringBuilder();
    File name = new File("src/test/studyGuide.md");
    try {
      Scanner scanner = new Scanner(name);
      while (scanner.hasNextLine()) {
        sb.append(scanner.nextLine());
        sb.append("\n");
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(sb.toString(), "# Java Arrays\n"
        + "- An **array** is a collection of variables of the same type\n"
        + "\n"
        + "## Declaring an Array\n"
        + "- General Form: type[] arrayName;\n"
        + "- only creates a reference\n"
        + "- no array has\n"
        + "\n"
        + "## Creating an Array (Instantiation)\n"
        + "- General form:  arrayName = new type[numberOfElements];\n"
        + "- numberOfElements must be a positive Integer.\n"
        + "- Gotcha: Array size is not  modifiable once instantiated.\n"
        + "\n"
        + "# Vectors\n"
        + "- Vectors act like a resizable array\n"
        + "\n"
        + "## Declaring a vector\n"
        + "- General Form: Vector<type> v = new Vector();\n"
        + "- type needs to be a valid reference type\n"
        + "\n"
        + "## Adding an element to a vector\n"
        + "- v.add(object of type);\n"
        + "\n");
    assertTrue(name.delete());
  }

  @Test
  public void testMainWithoutMarkDownFiles() {
    String[] args = {"src/test/resources/emptyDir", "n", "src/test/studyGuide.md"};
    Driver.main(args);
    StringBuilder sb = new StringBuilder();
    File name = new File("src/test/studyGuide.md");
    try {
      Scanner scanner = new Scanner(name);
      while (scanner.hasNextLine()) {
        sb.append(scanner.nextLine());
        sb.append("\n");
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(sb.toString(), "");
    assertTrue(name.delete());
  }

  /**
   * Tests the help message for Driver
   */
  @Test
  public void testHelpMessage() {
    String expected = "Please enter an \n"
        + "[input path], \n"
        + "[sort order (n - name, c - date created, m - date modified)], and an \n"
        + "[output path]";
    assertEquals(expected, Driver.helpMessage());
  }

  /**
   * Tests the main method for Driver with invalid input
   */
  @Test
  public void testMainWithFewInputs() {
    String[] args = {"src/test/resources/emptyDir", "src/test/studyGuide.md"};
    Driver.main(args);
    boolean fileExists = true;
    try {
      File name = new File("src/test/studyGuide.md");
      Scanner scanner = new Scanner(name);
      scanner.close();
    } catch (IOException e) {
      fileExists = false;
    }
    assertFalse(fileExists);
  }
}